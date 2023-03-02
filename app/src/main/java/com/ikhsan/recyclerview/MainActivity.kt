package com.ikhsan.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvClass: RecyclerView
    private val list = ArrayList<HomeWork>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClass = findViewById(R.id.rv_class)
        rvClass.setHasFixedSize(true)

        list.addAll(getListClasses())
        showRecyclerList()
    }

    private fun getListClasses(): ArrayList<HomeWork> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRating = resources.getStringArray(R.array.rating)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val descriptionClass = resources.getStringArray(R.array.data_description_class)
        val dataTarget = resources.getStringArray(R.array.data_target)
        val listClasses = ArrayList<HomeWork>()
        for (i in dataName.indices) {
            val classed = HomeWork(dataName[i], dataRating[i], dataDescription[i], dataPhoto.getResourceId(i, -1), descriptionClass[i], dataTarget[i])
            listClasses.add(classed)
        }
        return listClasses
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_page){
            val about =Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(about)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvClass.layoutManager = LinearLayoutManager(this)
        val listClassAdapter = ListClassAdapter(list)
        rvClass.adapter = listClassAdapter

        listClassAdapter.setOnItemClickCallback(object : ListClassAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HomeWork) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }
}