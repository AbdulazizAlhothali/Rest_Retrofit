package com.tuwaiq.restandretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tuwaiq.restandretrofit.R
import com.tuwaiq.restandretrofit.data.network.FlickrRepo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this).get(MainVM::class.java)
        vm.fetchInterestingList().observe(this, {
            Log.d("Flicker main Response", it.photos.toString())
        })
    }
}