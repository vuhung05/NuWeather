package com.nuweather.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nuweather.data.remote.error.ApiException
import com.nuweather.domain.usecase.UseCase
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel constructor(
    private vararg val useCases: UseCase<*, *>?
) : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<ApiException>()

    override fun onCleared() {
        compositeDisposable.dispose()
        useCases.let { if (it.isNotEmpty()) it.forEach { it!!.onCleared() } }
        super.onCleared()
    }

    fun enableLoading() {
        isLoading.value = true
    }

    fun disableLoading() {
        isLoading.value = false
    }

    fun setError(apiException: ApiException) {
        error.value = apiException
    }
}
