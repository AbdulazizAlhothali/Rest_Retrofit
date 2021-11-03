package com.tuwaiq.restandretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.restandretrofit.R

class MainActivity : AppCompatActivity() {
    private lateinit var flickrRV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flickrRV= findViewById(R.id.rvFlickr)
        flickrRV.layoutManager = GridLayoutManager(this, 2)

        val vm = ViewModelProvider(this).get(MainVM::class.java)
        vm.fetchInterestingList().observe(this, {
            flickrRV.adapter= FlickAdapter(it.photos.photo)
            Log.d("Flicker main Response", it.photos.toString())
        })


    }
}