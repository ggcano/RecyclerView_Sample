package com.example.recyclerview_sample.ui.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

import com.example.recyclerview_sample.R
import com.example.recyclerview_sample.models.domain.Pokemon
import com.example.recyclerview_sample.models.viewModel.PokemonViewModel
import com.example.recyclerview_sample.ui.adapter.PokemonAdapter


class PokemonFragment : Fragment() {
    @BindView (R.id.rvSuperheroList)
    lateinit var mRecyclerView : RecyclerView

    var viewModel:PokemonViewModel = PokemonViewModel()
    val mAdapter : PokemonAdapter = PokemonAdapter()

    val pokemonObserver = Observer<MutableList<Pokemon>> { pokemonList ->
        mAdapter.updateList(pokemonList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.activity_list, container, false)
        ButterKnife.bind(this,view)
        setUpRecyclerView()
        initViewModel()
        return view

    }

    fun initViewModel () {
        viewModel =
            ViewModelProviders.of(this).get(PokemonViewModel::class.java)

        viewModel.getPokemonReceived().observe(this, pokemonObserver)
    }
    fun setUpRecyclerView(){
        mAdapter.RecyclerAdapter(arrayListOf(), requireContext())
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter
    }

}
