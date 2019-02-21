package com.nuweather.data.remote.middleware

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.nuweather.data.remote.error.ApiException
import com.nuweather.data.remote.response.base.BaseErrorResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import java.lang.reflect.Type

class RxErrorHandlingCallAdapterFactory : CallAdapter.Factory() {

    private val original by lazy {
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    override fun get(returnType: Type,
                     annotations: Array<Annotation>,
                     retrofit: Retrofit): CallAdapter<*, *> {
        val wrapped = original.get(returnType, annotations, retrofit) as CallAdapter<*, *>
        return RxCallAdapterWrapper(wrapped)
    }

    private inner class RxCallAdapterWrapper<R>(
        val wrappedCallAdapter: CallAdapter<R, *>
    ) : CallAdapter<R, Single<R>> {

        override fun responseType(): Type = wrappedCallAdapter.responseType()


        @Suppress("UNCHECKED_CAST")
        override fun adapt(call: Call<R>): Single<R>? {
            return (wrappedCallAdapter.adapt(call) as Single<R>)
                .onErrorResumeNext { throwable: Throwable ->
                    Single.error(asApiException(throwable))
                }
        }

        private fun asApiException(throwable: Throwable): ApiException {
            if (throwable is HttpException) {
                throwable.response()?.let { response ->
                    try {
                        val errorResponse = response.errorBody()?.string()
                        errorResponse?.let {
                            val serverErrorResponse = deserializeServerError(it)
                            return if (serverErrorResponse != null &&
                                serverErrorResponse.code != "200") ApiException.serverError(serverErrorResponse)
                            else ApiException.httpError(response)
                        }
                    } catch (e: IOException) {
                        Log.e(TAG, e.message)
                    }
                }
            }

            if (throwable is IOException) {
                return ApiException.networkError(throwable)
            }
            return ApiException.unexpectedError(throwable)
        }

        private fun deserializeServerError(errorString: String): BaseErrorResponse? {
            val gson = GsonBuilder().create()
            return try {
                gson.fromJson(errorString, BaseErrorResponse::class.java)
            } catch (e: JsonSyntaxException) {
                null
            }
        }
    }

    companion object {
        private val TAG: String = RxErrorHandlingCallAdapterFactory::class.java.simpleName
        fun create(): CallAdapter.Factory = RxErrorHandlingCallAdapterFactory()
    }
}