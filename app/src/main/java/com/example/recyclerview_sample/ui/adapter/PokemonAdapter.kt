package com.example.recyclerview_sample.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_sample.R
import com.example.recyclerview_sample.models.domain.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_pokemon_list.view.*

class PokemonAdapter: RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    var pokemons: MutableList<Pokemon> = ArrayList()
    lateinit var context: Context


    fun RecyclerAdapter(pokemons: MutableList<Pokemon>, context: Context) {
        this.pokemons = pokemons
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokemons.get(position)
        var currentPostion =position

        holder.mPokemonName.text =item.pokemonName
        holder.mPokemonDescription.text = item.description
        holder.mPokemonImage.loadUrl(item.imagePokemon)

        holder.mPokemonImage.setOnLongClickListener{
           item.equals(deleteItem(datalist = pokemons, position = currentPostion))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_pokemon_list,
                parent,
                false))
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.with(context)
            .load(url)
            .into(this)
    }

    override fun getItemCount(): Int {
     return pokemons.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mPokemonName = view.pokemon_label_name as TextView
        val mPokemonDescription = view.pokemon_label_description as TextView
        val mPokemonImage = view.pokemon_img_url as ImageView

    }

    fun updateList(datalist: MutableList<Pokemon>){
        this.pokemons = datalist
        notifyDataSetChanged()
    }

    fun deleteItem (datalist: MutableList<Pokemon>, position: Int){
        this.pokemons = datalist
        datalist.removeAt(position)
        notifyDataSetChanged()
    }
}



