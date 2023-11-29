package com.teamfan.plantpedia.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class BookResponse(
    @Json(name = "title")
    val title: String? = null,

    @Json(name = "author")
    val author: String? = null
)

@JsonClass(generateAdapter = true)
@Parcelize
data class BookItem(
    @Json(name = "title")
    val title: String? = null,

    @Json(name = "author")
    val author: String? = null,

    @Json(name = "thumbnail")
    val thumbnail: String? = null,

    @Json(name = "selfLink")
    val selfLink: String? = null,

    @Json(name = "previewLink")
    val previewLink: String? = null
): Parcelable