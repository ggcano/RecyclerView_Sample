package com.example.recyclerview_sample.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    private val TAG = "Network"
    val CONNECT_TIMEOUT = 20000
    val WRITE_TIMEOUT = 20000
    val READ_TIMEOUT = 20000

    lateinit var pokeServices: PokeServices
    private val baseUrl = "http://www.mocky.io/v2/"

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val interceptor =  HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client = okHttpClient.addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        initServices(retrofit)
    }

    fun getPokemonsServices(): PokeServices {

        return pokeServices
    }

    fun initServices (retrofit: Retrofit) {
        pokeServices = retrofit.create(PokeServices::class.java)
    }
}