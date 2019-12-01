package com.example.recyclerview_sample.repositories

import com.example.recyclerview_sample.models.domain.Pokemon

interface PokemonRepository {
    fun generatePokemonList(): MutableList<Pokemon>

}