package com.tuwaiq.restandretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tuwaiq.restandretrofit.R

class MainActivity : AppCompatActivity() {
    private lateinit var flickrRV: RecyclerView
    private val vm by lazy{
        ViewModelProvider(this).get(MainVM::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flickrRV= findViewById(R.id.rvFlickr)
        flickrRV.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)    //GridLayoutManager(this, 2)

        loadFlickrImages()


    }

    private fun loadFlickrImages(query: String? = null) {
        vm.fetchInterestingList(query).observe(this, {
            flickrRV.adapter = FlickrAdapter(it.photos.photo)
            Log.d("Flicker main Response", it.photos.toString())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu,menu)
        val TAG= "searchView"
        val searchIcon: MenuItem= menu!!.findItem(R.id.app_bar_search)

        val searchView= searchIcon.actionView as SearchView
        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG,"QueryTextSubmit: $query")
                loadFlickrImages(query?.trim())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d(TAG,"QueryTextChange: $newText")
                return false
            }
        })
        }

        return super.onCreateOptionsMenu(menu)

    }
}