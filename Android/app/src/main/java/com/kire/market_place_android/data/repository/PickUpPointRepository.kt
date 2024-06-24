package com.kire.market_place_android.data.repository

import com.kire.market_place_android.data.mapper.admin.toDomain
import com.kire.market_place_android.data.remote.api.admin.IAdminApi
import com.kire.market_place_android.data.remote.dto.Error
import com.kire.market_place_android.data.remote.dto.request.admin.PickUpPointRequest
import com.kire.market_place_android.di.IoDispatcher
import com.kire.market_place_android.domain.model.admin.IAdminResultDomain
import com.kire.market_place_android.domain.repository.IPickUpPointRepository

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
class PickUpPointRepository @Inject constructor(
    private val adminApi: IAdminApi,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
): IPickUpPointRepository {

    // get all KubMarket's pick-up points
    // and return Success with resulting list or Error status of IAdminResultDomain sealed interface
    override suspend fun getAllPickUpPoints(): IAdminResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                val response = adminApi.getAllPickUpPoints().toDomain()
                IAdminResultDomain.Success(response)

            } catch (e: Error){
                IAdminResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: Exception) {
                IAdminResultDomain.Error(e.message)
            }
        }
    }

    // create new KubMarket's pick-up point
    // and return SuccessfullyDone or Error status of IAdminResultDomain sealed interface
    override suspend fun createPickUpPoint(managerId: Int, address: String): IAdminResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                adminApi.createPickUpPoint(PickUpPointRequest(managerId = managerId, address = address))
                IAdminResultDomain.SuccessfullyDone
            } catch (e: Error){
                IAdminResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: Exception) {
                IAdminResultDomain.Error(e.message)
            }
        }
    }

    // update existing KubMarket's pick-up point
    // and return SuccessfullyDone or Error status of IAdminResultDomain sealed interface
    override suspend fun updatePickUpPoint(id: Int, managerId: Int, address: String): IAdminResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                adminApi.updatePickUpPoint(id, PickUpPointRequest(managerId = managerId, address = address))
                IAdminResultDomain.SuccessfullyDone
            } catch (e: Error){
                IAdminResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: Exception) {
                IAdminResultDomain.Error(e.message)
            }
        }
    }

    // delete existing KubMarket's pick-up point
    // and return SuccessfullyDone or Error status of IAdminResultDomain sealed interface
    override suspend fun deletePickUpPoint(id: Int): IAdminResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                adminApi.deletePickUpPoint(id)
                IAdminResultDomain.SuccessfullyDone
            } catch (e: Error){
                IAdminResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IAdminResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IAdminResultDomain.Error(e.message)

            } catch (e: Exception) {
                IAdminResultDomain.Error(e.message)
            }
        }
    }
}