package com.tuwaiq.restandretrofit.data.network

import com.tuwaiq.restandretrofit.BuildConfig
import com.tuwaiq.restandretrofit.data.network.models.FlickrData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrAPI {

    @GET("?method=flickr.interestingness.getList&api_key=${BuildConfig.flickrAPIKey}&format=json&nojsoncallback=1&extras=url_s")
    suspend fun fetchPhotos(): FlickrData

    @GET("?method=flickr.photos.search&api_key=${BuildConfig.flickrAPIKey}&format=json&nojsoncallback=1&extras=url_s&safe_search=1")
    suspend fun searchPhotos(@Query("text") searchKeyWord: String): FlickrData
}