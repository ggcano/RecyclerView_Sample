package com.example.recyclerview_sample

import android.app.Application
import com.example.recyclerview_sample.repositories.PokemonRepository
import com.example.recyclerview_sample.repositories.PokemonRepositoryImpl
import com.example.recyclerview_sample.repositories.SuperHeroRepositoryImpl
import com.example.recyclerview_sample.repositories.SuperHeroRepostirory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(appModule)
        }
    }

    private val appModule = module {

        single<SuperHeroRepostirory> { SuperHeroRepositoryImpl() }
        single<PokemonRepository> { PokemonRepositoryImpl()}
    }
}
