package com.kire.market_place_android.data.remote.dto.response.product

import com.kire.market_place_android.data.remote.dto.response.util.serializer.BigDecimalSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class ProductResponse(
    @SerialName("product_id")
    val id: Int = 0,
    val title: String = "",
    @SerialName("image_url")
    val imageUrl: String = "",
    val description: String = "",
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal = 0.0.toBigDecimal(),
    @Serializable(with = BigDecimalSerializer::class)
    @SerialName("discount_price")
    val discountPrice: BigDecimal = 0.0.toBigDecimal(),
    @SerialName("quantity_of_available")
    val quantityAvailable: Int = 0,
    val unit: String = "",
    @SerialName("delivery_days")
    val deliveryDays: Int = 0,
    val category: CategoryResponse = CategoryResponse()
)
