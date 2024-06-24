package com.kire.market_place_android.data.remote.api.product

import com.kire.market_place_android.data.remote.dto.HttpRoutes
import com.kire.market_place_android.data.remote.dto.request.product.ProductRequest
import com.kire.market_place_android.data.remote.dto.response.product.CategoryResponse
import com.kire.market_place_android.data.remote.dto.response.product.ProductResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class ProductApi @Inject constructor(
    private val client: HttpClient
): IProductApi {

    // get all products presented in the store
    override suspend fun getAllProducts(): List<ProductResponse> {
        return client.get {
            url(HttpRoutes.GET_ALL_PRODUCTS)
            contentType(ContentType.Application.Json)
        }.body<List<ProductResponse>>()
    }

    // get all products' categories
    // like 'fruits', 'vegetables', 'electronic' and so on
    override suspend fun getAllAvailableCategories(): List<CategoryResponse> {
        return client.get {
            url(HttpRoutes.GET_ALL_AVAILABLE_CATEGORIES)
            contentType(ContentType.Application.Json)
        }.body<List<CategoryResponse>>()
    }

    // update product info by its id
    override suspend fun updateProductById(id: Int, product: ProductRequest) {
        client.patch {
            url(HttpRoutes.UPDATE_PRODUCT_BY_ID + id.toString())
            contentType(ContentType.Application.Json)
            setBody(product)
        }
    }

    // add new product to the store
    override suspend fun addProduct(product: ProductRequest) {
        client.post {
            url(HttpRoutes.ADD_PRODUCT)
            contentType(ContentType.Application.Json)
            setBody(product)
        }
    }
}