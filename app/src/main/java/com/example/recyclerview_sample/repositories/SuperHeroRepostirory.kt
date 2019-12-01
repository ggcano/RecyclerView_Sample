package com.example.recyclerview_sample.repositories

import androidx.lifecycle.MutableLiveData
import com.example.recyclerview_sample.models.domain.Superhero

interface SuperHeroRepostirory {
    fun generateSuperHeroList(): MutableLiveData<MutableList<Superhero>>
}