package com.example.recyclerview_sample.models.dto

import com.google.gson.annotations.SerializedName

class ImagesDTO (

    @SerializedName("id")
    val id: Int,

    @SerializedName("url")
    val url: String
)