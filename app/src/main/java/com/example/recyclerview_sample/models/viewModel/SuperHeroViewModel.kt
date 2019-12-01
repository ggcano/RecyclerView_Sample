package com.example.recyclerview_sample.models.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview_sample.models.domain.Superhero
import com.example.recyclerview_sample.repositories.SuperHeroRepositoryImpl

class SuperHeroViewModel:ViewModel () {

    val mutableList: MutableLiveData<MutableList<Superhero>>
    val repository: SuperHeroRepositoryImpl = SuperHeroRepositoryImpl()

    init {
        mutableList = repository.generateSuperHeroList()
    }

    fun getSuperHeroReceived(): LiveData<MutableList<Superhero>> {
        return mutableList
    }

}