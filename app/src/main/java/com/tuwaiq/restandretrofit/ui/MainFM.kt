package com.tuwaiq.restandretrofit.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuwaiq.restandretrofit.data.network.FlickrRepo
import com.tuwaiq.restandretrofit.data.network.models.FlickrData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainVM: ViewModel() {

    val repo = FlickrRepo()
    fun fetchInterestingList(): LiveData<FlickrData>{
        val photos = MutableLiveData<FlickrData>()
        viewModelScope.launch {
            try {
                photos.postValue(repo.fetchInterestingList())
            } catch (e: Throwable){
                Log.e("Flickr Images","Flickr Images Problem: ${e.localizedMessage}")
            }

        }
        return photos
    }

}

