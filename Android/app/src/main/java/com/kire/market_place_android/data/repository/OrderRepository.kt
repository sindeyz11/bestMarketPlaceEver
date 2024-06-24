package com.kire.market_place_android.data.repository

import com.kire.market_place_android.data.mapper.order.toDomain
import com.kire.market_place_android.data.remote.dto.Error
import com.kire.market_place_android.data.remote.api.order.IOrderApi
import com.kire.market_place_android.di.IoDispatcher
import com.kire.market_place_android.domain.model.order.IOrderResultDomain
import com.kire.market_place_android.domain.repository.IOrderRepository
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
class OrderRepository @Inject constructor(
    private val orderApi: IOrderApi,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
): IOrderRepository {

    // get all user's orders and return result
    // as sealed interface containing success, idle, error statuses
    override suspend fun getOrdersByUser(): IOrderResultDomain {
        return withContext(coroutineDispatcher) {
            try {
                val response = orderApi.getOrdersByUser()

                IOrderResultDomain.Success(response.toDomain())
            } catch (e: Error){
                IOrderResultDomain.Error(e.message)

            } catch (e: RedirectResponseException) {
                IOrderResultDomain.Error(e.response.bodyAsText())

            } catch (e: ClientRequestException) {

                IOrderResultDomain.Error(e.response.bodyAsText())

            } catch (e: ServerResponseException) {
                IOrderResultDomain.Error(e.response.bodyAsText())

            } catch (e: JsonConvertException) {
                IOrderResultDomain.Error(e.message)
            }
            catch (e: NoTransformationFoundException) {
                IOrderResultDomain.Error(e.message)

            } catch (e: Exception) {
                IOrderResultDomain.Error(e.message)
            }
        }
    }
}