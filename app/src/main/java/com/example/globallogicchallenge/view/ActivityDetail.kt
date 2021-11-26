package com.example.globallogicchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.globallogicchallenge.databinding.ActivityDetailBinding

class ActivityDetail : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        binding.outputDetailTitle.text = extras?.getString("title")
        binding.outputDetailDescription.text = extras?.getString("description")
        binding.outputDetailImage.load(extras?.getString("image")?.replace("photos.ar","photos"))


    }
}
