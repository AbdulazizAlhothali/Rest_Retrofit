package com.tuwaiq.restandretrofit.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuwaiq.restandretrofit.data.network.models.FlickrData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class FlickrRepo {

    private val api = FlickerBuilder.flickrAPI

    suspend fun fetchInterestingList():FlickrData= withContext(Dispatchers.IO){
       api.fetchPhotos()
    }
}