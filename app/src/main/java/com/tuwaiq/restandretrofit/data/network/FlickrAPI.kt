package com.tuwaiq.restandretrofit.data.network

import com.tuwaiq.restandretrofit.BuildConfig
import com.tuwaiq.restandretrofit.data.network.models.FlickrData
import retrofit2.Call
import retrofit2.http.GET

interface FlickrAPI {

    @GET("?method=flickr.interestingness.getList&api_key=${BuildConfig.flickrAPIKey}&format=json&nojsoncallback=1&extras=url_s")
    suspend fun fetchPhotos(): FlickrData
}