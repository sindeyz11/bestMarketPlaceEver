package com.kire.market_place_android.data.repository

import com.kire.market_place_android.data.mapper.admin.toDomain
import com.kire.market_place_android.data.remote.api.admin.IAdminApi
import com.kire.market_place_android.data.remote.api.manager.IManagerApi
import com.kire.market_place_android.data.remote.api.manager.ManagerApi
import com.kire.market_place_android.data.remote.dto.Error
import com.kire.market_place_android.data.remote.dto.request.admin.PickUpPointRequest
import com.kire.market_place_android.di.IoDispatcher
import com.kire.market_place_android.domain.model.IRequestResultDomain
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
    private val managerApi: IManagerApi,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
): IPickUpPointRepository {

    // get all KubMarket's pick-up points
    // and return Success with resulting list or Error status of IAdminResultDomain sealed interface
    override suspend fun getAllPickUpPoints(): IRequestResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                val response = adminApi.getAllPickUpPoints().toDomain()
                IRequestResultDomain.Success(response)

            } catch (e: Error){
                IRequestResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: Exception) {
                IRequestResultDomain.Error(e.message)
            }
        }
    }

    // create new KubMarket's pick-up point
    // and return SuccessfullyDone or Error status of IAdminResultDomain sealed interface
    override suspend fun createPickUpPoint(managerId: Int, address: String): IRequestResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                adminApi.createPickUpPoint(PickUpPointRequest(managerId = managerId, address = address))
                IRequestResultDomain.SuccessfullyDone
            } catch (e: Error){
                IRequestResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: Exception) {
                IRequestResultDomain.Error(e.message)
            }
        }
    }

    // update existing KubMarket's pick-up point
    // and return SuccessfullyDone or Error status of IAdminResultDomain sealed interface
    override suspend fun updatePickUpPoint(id: Int, managerId: Int, address: String): IRequestResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                adminApi.updatePickUpPoint(id, PickUpPointRequest(managerId = managerId, address = address))
                IRequestResultDomain.SuccessfullyDone
            } catch (e: Error){
                IRequestResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: Exception) {
                IRequestResultDomain.Error(e.message)
            }
        }
    }

    // delete existing KubMarket's pick-up point
    // and return SuccessfullyDone or Error status of IAdminResultDomain sealed interface
    override suspend fun deletePickUpPoint(id: Int): IRequestResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                adminApi.deletePickUpPoint(id)
                IRequestResultDomain.SuccessfullyDone
            } catch (e: Error){
                IRequestResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: Exception) {
                IRequestResultDomain.Error(e.message)
            }
        }
    }

    override suspend fun getPickUpPointByManagerId(id: Int): IRequestResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                val response = managerApi.getPickUpPointByManagerId(id).toDomain()
                IRequestResultDomain.Success(response)
            } catch (e: Error){
                IRequestResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IRequestResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: NoTransformationFoundException) {
                IRequestResultDomain.Error(e.message)

            } catch (e: Exception) {
                IRequestResultDomain.Error(e.message)
            }
        }
    }
}