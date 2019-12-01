package com.example.recyclerview_sample.ui.activities

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.recyclerview_sample.R
import com.example.recyclerview_sample.models.domain.Superhero
import com.example.recyclerview_sample.models.viewModel.SuperHeroViewModel
import com.example.recyclerview_sample.ui.adapter.SuperHeroAdapter
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SuperHeroFragment : Fragment(){

    @BindView(R.id.rvSuperheroList)
    lateinit var mRecyclerView: RecyclerView
    var viewModel: SuperHeroViewModel = SuperHeroViewModel()
    var mAdapter: SuperHeroAdapter = SuperHeroAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_list, container, false)
        ButterKnife.bind(this, view)
        initViewModel()
        setUpRecyclerView()
        return view
    }

    fun initViewModel() {
        viewModel =
            ViewModelProviders.of(this).get(SuperHeroViewModel::class.java)
        viewModel.getSuperHeroReceived().observe(this, Observer { superheroList ->
            mAdapter.SuperHeroAdapter(superheroList, requireContext())
            mRecyclerView.scrollToPosition(0)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.dc_id ->
                mRecyclerView.layoutManager =
                    GridLayoutManager(context, resources.getInteger(R.integer.nameOfColumns))

            R.id.marvel_id ->
                mRecyclerView.layoutManager = LinearLayoutManager(context)
        }

        return super.onOptionsItemSelected(item)
    }

    fun setUpRecyclerView() {
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter
    }


}