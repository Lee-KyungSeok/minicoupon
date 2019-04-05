package io.gameper.gampingmall.utils

import java.util.regex.Pattern

fun String.isPhone(): Boolean {
    val regex = "^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$"
    val p = Pattern.compile(regex)
    val m = p.matcher(this)
    return m.matches()
}