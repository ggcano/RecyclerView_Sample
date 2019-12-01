package com.example.recyclerview_sample.models.dto

import com.google.gson.annotations.SerializedName

data class PokemonsDTO (
    @SerializedName("id")
    val id: Int,

    @SerializedName ("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("images")
    val images: List<ImagesDTO>
    )