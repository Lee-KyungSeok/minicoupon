package io.gameper.gampingmall.utils

import android.annotation.SuppressLint
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer: JsonDeserializer<Date> {

    @SuppressLint("SimpleDateFormat")
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date {
        val date = json?.asString

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        formatter.timeZone = TimeZone.getTimeZone("GMT")

        try {
            return formatter.parse(date)
        } catch (e: ParseException) {
            throw Exception("DateDeserializer://Cannot change time format")
        }
    }
}