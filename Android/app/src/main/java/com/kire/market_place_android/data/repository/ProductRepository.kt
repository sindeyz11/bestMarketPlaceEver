package com.kire.market_place_android.data.repository

import com.kire.market_place_android.data.mapper.product.toDomain
import com.kire.market_place_android.data.remote.dto.Error
import com.kire.market_place_android.data.remote.api.product.IProductApi
import com.kire.market_place_android.di.IoDispatcher
import com.kire.market_place_android.domain.model.IRequestResultDomain
import com.kire.market_place_android.domain.repository.IProductRepository

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
class ProductRepository @Inject constructor(
    private val productApi: IProductApi,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
): IProductRepository {

    // get all products presented in KubMarket
    // return Success with resulting list or Error status of IProductResultDomain sealed interface
    override suspend fun getAllProducts(): IRequestResultDomain {

        return withContext(coroutineDispatcher) {

            try {
                val response = productApi.getAllProducts()

                //Save to local
                //............

                IRequestResultDomain.Success(response.toDomain())

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

    // get all categories that products presented in KubMarket have
    // return Success with resulting list or Error status of IProductResultDomain sealed interface
    override suspend fun getAllAvailableCategories():  IRequestResultDomain {
        return withContext(coroutineDispatcher) {

            try {
                val response = productApi.getAllAvailableCategories()

                //Save to local
                //............

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