package com.kire.market_place_android.data.repository

import com.kire.market_place_android.domain.model.auth.AuthResultDomain
import com.kire.market_place_android.data.model.auth.Token
import com.kire.market_place_android.data.remote.dto.request.auth.LogOnRequest
import com.kire.market_place_android.data.remote.api.auth.IAuthApi
import com.kire.market_place_android.data.remote.dto.Errors
import com.kire.market_place_android.di.IoDispatcher
import com.kire.market_place_android.domain.repository.ILogOnRepository
import com.kire.market_place_android.domain.repository.ITokenStorageRepository

import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.JsonConvertException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import javax.inject.Inject

/**
 * By Michael Gontarev (KiREHwYE)*/
class LogOnRepository @Inject constructor(
    private val authApi: IAuthApi,
    private val tokenStorageRepository: ITokenStorageRepository,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
): ILogOnRepository {

    // log-on and return result
    // as sealed class containing authorized, unauthorized, unknown error statuses
    override suspend fun logOn(
        username: String,
        phone: String,
        email: String,
        password: String
    ): AuthResultDomain<String> {

        return withContext(coroutineDispatcher) {
            try {
                val response = authApi.logOn(
                    request = LogOnRequest(
                        username = username,
                        phone = phone,
                        email = email,
                        password = password
                    )
                )
                tokenStorageRepository.store(
                    token = Token(
                        token = response.token,
                        role = response.role,
                        userId = response.userId
                    )
                )

                authApi.triggerLoadTokens()

                AuthResultDomain.Authorized()

            } catch (e: Errors){
                AuthResultDomain.UnknownError(e.message)

            } catch (e: RedirectResponseException) {
                AuthResultDomain.UnknownError(e.response.bodyAsText())

            } catch (e: ClientRequestException) {
                AuthResultDomain.UnknownError(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                AuthResultDomain.UnknownError(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                AuthResultDomain.UnknownError(e.message)

            } catch (e: NoTransformationFoundException) {
                AuthResultDomain.UnknownError(e.message)

            } catch (e: Exception) {
                AuthResultDomain.UnknownError(e.message)
            }
        }
    }

}