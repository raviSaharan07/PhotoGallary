package com.android.photogallery.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ItemUrl(
    val regular:String
)