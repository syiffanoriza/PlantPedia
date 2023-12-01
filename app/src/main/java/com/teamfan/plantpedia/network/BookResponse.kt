package com.teamfan.plantpedia.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class BookResponse(
    @Json(name = "totalItems")
    val totalItems: String? = null,

    @Json(name = "kind")
    val kind: String? = null,

    @Json(name = "items")
    val items: List<BookItem>? = null
)

@JsonClass(generateAdapter = true)
@Parcelize
data class BookItem(
    @Json(name = "selfLink")
    val selfLink: String? = null,

    @Json(name = "volumeInfo")
    val volumeInfo: BookDetail? = null,
): Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class BookDetail(
    @Json(name = "title")
    val title: String? = null,

    @Json(name = "authors")
    val authors: List<String>? = null,

    @Json(name = "publishedDate")
    val publishedDate: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "imageLinks")
    val imageLinks: ImageLinks? = null
): Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class ImageLinks(
    @Json(name = "smallThumbnail")
    val smallThumbnail: String? = null,

    @Json(name = "thumbnail")
    val thumbnail: String? = null
): Parcelable