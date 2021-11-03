package com.tuwaiq.restandretrofit.data.network.models

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class FlickrData (
    val photos: FPhotos
)
data class FPhotos (
    val photo: List<FPhoto>
)

data class FPhoto (
    var title: String,
    @SerializedName("url_s")
    var url: String)