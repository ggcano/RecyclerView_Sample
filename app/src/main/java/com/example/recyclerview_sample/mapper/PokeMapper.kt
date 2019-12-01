package com.example.recyclerview_sample.mapper

import com.example.recyclerview_sample.models.domain.Pokemon
import com.example.recyclerview_sample.models.dto.ListPokemonsDTO
import com.example.recyclerview_sample.models.dto.PokemonsDTO
import java.util.ArrayList

object PokeMapper {

    fun toListDomain(dtoList: ListPokemonsDTO ): MutableList<Pokemon> {
        val entities = ArrayList<Pokemon>()

        for (dto in dtoList.listpokemons) {
            entities.add(entityFrom(dto))
        }
        return entities
    }

    fun entityFrom (dto: PokemonsDTO):Pokemon {
        return Pokemon(
            pokemonName = dto.name,
            imagePokemon = dto.images[1].url,
            description = dto.description

           // dto.name, dto.description, dto.images[1].url)
        )
    }
}