package com.android.photogallery.api

import retrofit2.http.GET

interface FlickrApi {
    @GET("photos/?per_page=30"+
    "&client_id=1ryoFYu5oHYMm3HuTTP4vOa_WYQff5ClfPSdEO3ZedY")
    suspend fun fetchPhotos(): List<GalleryItem>
}