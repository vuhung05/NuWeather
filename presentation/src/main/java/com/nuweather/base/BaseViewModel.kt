package com.nuweather.base

import android.arch.lifecycle.ViewModel
import com.nuweather.domain.usecase.UseCase
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel constructor(
        vararg val useCases: UseCase<*, *>?
) : ViewModel() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        useCases.let { if (it.isNotEmpty()) it.forEach { it!!.onCleared() } }
        super.onCleared()
    }
}
