package com.ikhsan.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail"

        val data = intent.getParcelableExtra<HomeWork>("DATA")

        val imgHomeWork = findViewById<ImageView>(R.id.img_item_photo)
        val tvName = findViewById<TextView>(R.id.tv_item_name)
        val tvRating = findViewById<TextView>(R.id.tv_rating)
        val tvDescription = findViewById<TextView>(R.id.tv_item_description)
        val tvDescriptionClass = findViewById<TextView>(R.id.tv_description_class)
        val tvTarget = findViewById<TextView>(R.id.tv_target)

        imgHomeWork.setImageResource(data?.photo?: 0)
        tvName.text = data?.name
        tvRating.text = data?.rating
        tvDescription.text = data?.description
        tvDescriptionClass.text = data?.descriptionClass
        tvTarget.text = data?.target
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val data = intent.getParcelableExtra<HomeWork>("DATA")

        val nama = data?.name
        val description = data?.description

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "$nama\n $description")
            type ="text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
        return super.onOptionsItemSelected(item)
    }
}