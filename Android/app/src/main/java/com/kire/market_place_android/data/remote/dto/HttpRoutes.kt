package com.kire.market_place_android.data.remote.dto

object HttpRoutes {

    private const val BASE_URL = "http://195.43.142.92/api/v1"

    //Authentication
    const val AUTH_LOGIN = "$BASE_URL/auth"
    const val AUTH_REGISTER = "$BASE_URL/auth/register"

    //User
    const val USER_INFO_BY_ID = "$BASE_URL/users/"
    const val CHANGE_PASSWORD = "$BASE_URL/users/password"
    const val CHANGE_CARD = "$BASE_URL/users/card"
    const val CHANGE_INFO_BY_ID = "$BASE_URL/users/"
    const val ALL_USERS = "$BASE_URL/users"

    //Product
    const val GET_ALL_PRODUCTS = "$BASE_URL/product/assortment"
    const val GET_SPECIAL_OFFERS = "$BASE_URL/product/special"
    const val GET_ALL_AVAILABLE_CATEGORIES = "$BASE_URL/product/categories"
    const val ADD_PRODUCT = "$BASE_URL/product"
    const val UPDATE_PRODUCT_BY_ID = "$BASE_URL/product/"

    //Order
    const val GET_ORDERS_BY_USER = "$BASE_URL/orders/user"

    //Admin
    const val GET_ALL_PICK_UP_POINTS = "$BASE_URL/points"
    const val CREATE_PICK_UP_POINT = "$BASE_URL/points"
    const val UPDATE_PICK_UP_POINT_BY_ID = "$BASE_URL/points/"
    const val DELETE_PICK_UP_POINT_BY_ID = "$BASE_URL/points/"
}