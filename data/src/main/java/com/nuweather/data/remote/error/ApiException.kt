package com.nuweather.data.remote.error

import com.nuweather.data.remote.response.BaseErrorResponse
import retrofit2.Response
import java.io.IOException

class ApiException(
    private val kind: Kind,
    private val serverErrorResponse: BaseErrorResponse? = null,
    private val response: Response<*>? = null,
    private val exception: Throwable? = null
) : RuntimeException() {

    companion object {
        fun httpError(response: Response<*>): ApiException {
            return ApiException(Kind.HTTP, null, response)
        }

        fun serverError(serverErrorResponse: BaseErrorResponse): ApiException {
            return ApiException(Kind.SERVER, serverErrorResponse)
        }

        fun networkError(throwable: Throwable): ApiException {
            return ApiException(Kind.NETWORK, null, null, throwable)
        }

        fun unexpectedError(throwable: Throwable): ApiException {
            return ApiException(Kind.UNEXPECTED, null, null, throwable)
        }
    }

    fun getServerError(): BaseErrorResponse? {
        return if (kind == Kind.SERVER) {
            return serverErrorResponse
        } else null
    }

    fun getServerMessage(): String? {
        return if (kind == Kind.SERVER) {
            serverErrorResponse?.message
        } else null
    }

    fun getServerErrorCode(): String? {
        return if (kind == Kind.SERVER) {
            serverErrorResponse?.code
        } else null
    }

    fun isNetworkError(): Boolean {
        return kind == Kind.NETWORK
    }

    fun isServerError(): Boolean {
        return kind == Kind.SERVER
    }

    fun isHttpError(): Boolean {
        return kind == Kind.HTTP
    }

    fun isUnexpectedError(): Boolean {
        return kind == Kind.UNEXPECTED
    }

    enum class Kind {
        /** An [IOException] occurred while communicating to the server.  */
        NETWORK,
        /** A non-200 HTTP status code was received from the server.  */
        HTTP,
        SERVER,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED
    }
}