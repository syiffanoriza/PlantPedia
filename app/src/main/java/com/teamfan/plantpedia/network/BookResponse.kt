package com.teamfan.plantpedia.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookResponse(
    @Json(name = "title")
    val title: String? = null,

    @Json(name = )
)