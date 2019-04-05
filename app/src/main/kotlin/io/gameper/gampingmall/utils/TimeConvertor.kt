package io.gameper.gampingmall.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.toDate(pattern: String): Date {
    return SimpleDateFormat(pattern).parse(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.convertToString(pattern: String): String {
    return SimpleDateFormat(pattern).format(this)
}