package com.example.workshala2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity_param : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var recyclerViewCategoryAdapter : RecyclerViewCategoryAdapter? = null
    private var movieList = mutableListOf<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_param)

        movieList = ArrayList()

        recyclerView = findViewById<View>(R.id.rvMovieLists) as RecyclerView
        recyclerViewCategoryAdapter = RecyclerViewCategoryAdapter(this@MainActivity_param, movieList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewCategoryAdapter

        prepareMovieListData()

    }

    private fun prepareMovieListData(){
        var category = Category("Crypto", R.drawable.icon_crypto1)
        movieList.add(category)

        category = Category("Banking", R.drawable.icon_banking)
        movieList.add(category)
        category = Category("Programming", R.drawable.icon_programming)
        movieList.add(category)
        category = Category("Food & Restaurant", R.drawable.icon_restaurant)
        movieList.add(category)
        category = Category("Human Resources", R.drawable.icon_human)
        movieList.add(category)
        category = Category("Content Writer", R.drawable.icon_contentwriter)
        movieList.add(category)
        category = Category("Arts and Design", R.drawable.icon_arts)
        movieList.add(category)
        category = Category("Customer Services", R.drawable.icon_customer)
        movieList.add(category)

        recyclerViewCategoryAdapter!!.notifyDataSetChanged()
    }
}

