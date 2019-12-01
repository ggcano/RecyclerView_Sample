package com.example.recyclerview_sample.models.dto

import com.google.gson.annotations.SerializedName

data class ListPokemonsDTO (
    @SerializedName("pokemons")
    val listpokemons: MutableList<PokemonsDTO>
)