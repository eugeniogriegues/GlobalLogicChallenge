package com.example.globallogicchallenge.model

import com.squareup.moshi.Json

data class Item (

    @Json(name="title") val title: String,
    @Json(name="description") val description: String,
    @Json(name="image") val image: String

)