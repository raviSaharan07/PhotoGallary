package com.android.photogallery.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem(
    @Json(name="alt_description") val title:String,
    val id:String,
    @Json(name="urls") val url:ItemUrl)
