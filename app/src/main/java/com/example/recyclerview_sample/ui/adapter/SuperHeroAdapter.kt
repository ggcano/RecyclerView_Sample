package com.example.recyclerview_sample.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_sample.R
import com.example.recyclerview_sample.models.domain.Pokemon
import com.example.recyclerview_sample.models.domain.Superhero
import kotlinx.android.synthetic.main.item_superhero_list.view.*
import okhttp3.internal.notify

class SuperHeroAdapter: RecyclerView.Adapter<SuperHeroAdapter.ViewHolder>() {
    var superheros: MutableList<Superhero> = ArrayList()
    lateinit var context: Context


    fun SuperHeroAdapter (superheros : MutableList<Superhero>, context: Context){
        this.superheros = superheros
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros[position]

        holder.superheroName.text = item.superhero
        holder.realName.text = item.realName
        holder.publisher.text =item.publisher
        holder.avatar.loadUrl(item.photo)

        holder.avatar.setOnLongClickListener {
        item.equals(deleteItem(datalist = superheros, position = position))
}

    }
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context)
            .load(url)
            .into(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_superhero_list,
                parent,
                false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val superheroName = view.tvSuperhero as TextView
        val realName = view.tvRealName as TextView
        val publisher = view.tvPublisher as TextView
        val avatar = view.ivAvatar as ImageView

        }

    fun deleteItem (datalist: MutableList<Superhero>, position: Int){
        this.superheros = datalist
        datalist.removeAt(position)
        notifyDataSetChanged()
    }

}
