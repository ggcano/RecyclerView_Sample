package com.example.recyclerview_sample.models.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview_sample.models.domain.Pokemon
import com.example.recyclerview_sample.repositories.PokemonRepositoryImpl

class PokemonViewModel:ViewModel (){

    val mutableList: MutableLiveData<MutableList<Pokemon>>
    val repository: PokemonRepositoryImpl = PokemonRepositoryImpl()

    init {
        mutableList = repository.getPokemonsFromApi()
    }

    fun getPokemonReceived(): LiveData<MutableList<Pokemon>> {
        return mutableList
    }

}