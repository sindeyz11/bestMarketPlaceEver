package com.kire.market_place_android.presentation.util


/**
 * Форматирует число Double в денежный формат с двумя знаками после запятой.
 *
 * @return Строковое представление числа в денежном формате.
 * @author Aleksey Timko (de4ltt)
 */
fun Double.toMonetaryFormat(): String = "%.2f".format(this)