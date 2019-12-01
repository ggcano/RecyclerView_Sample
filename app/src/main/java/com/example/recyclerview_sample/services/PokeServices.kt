package com.example.recyclerview_sample.services

import com.example.recyclerview_sample.models.dto.ListPokemonsDTO
import retrofit2.Call
import retrofit2.http.GET

interface PokeServices {

    @GET("5d8cabc22e0000bcababdbfd")
    fun getPokemones(): Call<ListPokemonsDTO>
}