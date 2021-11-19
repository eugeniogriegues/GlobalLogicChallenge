package com.example.globallogicchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.globallogicchallenge.R

class ActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        val title = findViewById<TextView>(R.id.output_detail_title)
        val description = findViewById<TextView>(R.id.output_detail_description)
        val image = findViewById<ImageView>(R.id.output_detail_image)

        val extras = intent.extras

        title.text = extras?.getString("title")
        description.text = extras?.getString("description")
        image.load(extras?.getString("image")?.replace("photos.ar","photos"))





    }
}