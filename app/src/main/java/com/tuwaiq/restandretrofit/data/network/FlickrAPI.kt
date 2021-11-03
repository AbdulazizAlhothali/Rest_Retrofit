package com.tuwaiq.restandretrofit.data.network

import com.tuwaiq.restandretrofit.data.network.models.FlickrData
import retrofit2.Call
import retrofit2.http.GET

interface FlickrAPI {

    @GET("?method=flickr.interestingness.getList&api_key=1af94995d28f2982c2f46b0217d23524&format=json&nojsoncallback=1&extras=url_s")
    suspend fun fetchPhotos(): FlickrData
}