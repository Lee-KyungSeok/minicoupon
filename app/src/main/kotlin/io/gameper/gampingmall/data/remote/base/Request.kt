package io.gameper.gampingmall.data.remote.base

data class Request(
    val method: String,
    val type: String,
    val url: String
)