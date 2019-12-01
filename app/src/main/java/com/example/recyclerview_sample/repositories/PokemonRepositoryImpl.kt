package com.example.recyclerview_sample.repositories

import androidx.lifecycle.MutableLiveData
import com.example.recyclerview_sample.mapper.PokeMapper
import com.example.recyclerview_sample.models.domain.Pokemon
import com.example.recyclerview_sample.models.dto.ListPokemonsDTO
import com.example.recyclerview_sample.services.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl: PokemonRepository {

    val restClient: RestClient = RestClient()

    override fun generatePokemonList(): MutableList<Pokemon> {
        val pokemones :MutableList<Pokemon> = ArrayList()

        pokemones.add(
            Pokemon(
                "Ditto",
                "bla bla bla 1",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/132.png"
            )
        )
        pokemones.add(
            Pokemon(
                "Pikachu",
                "bla bla 2",
                "https://secure.img1-fg.wfcdn.com/im/02238154/compr-r85/8470/84707680/pokemon-pikachu-wall-decal.jpg"
            )
        )

        pokemones.add(
            Pokemon(
                "Bulbasur",
                "bla bla 2",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"
            )
        )

    return pokemones
    }

    fun getPokemonsFromApi ():MutableLiveData<MutableList<Pokemon>> {
        val mutableLiveData: MutableLiveData<MutableList<Pokemon>> = MutableLiveData()

        val call = restClient.getPokemonsServices().getPokemones()
        call.enqueue(object : Callback<ListPokemonsDTO> {
            override fun onFailure(call: Call<ListPokemonsDTO>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<ListPokemonsDTO>?, response: Response<ListPokemonsDTO>?) {
                mutableLiveData.value = PokeMapper.toListDomain(response?.body()!!)
            }
        })

        return mutableLiveData
    }
}