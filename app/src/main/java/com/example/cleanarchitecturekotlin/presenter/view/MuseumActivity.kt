package com.example.cleanarchitecturekotlin.presenter.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.cleanarchitecturekotlin.R
import com.example.cleanarchitecturekotlin.domain.di.Injection
import com.example.cleanarchitecturekotlin.datas.Museum
import com.example.cleanarchitecturekotlin.domain.usecases.MuseumViewModel
import kotlinx.android.synthetic.main.activity_museum.*



class MuseumActivity : BaseActivity() {

    private lateinit var viewModel: MuseumViewModel
    private lateinit var adapter: MuseumAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        setupViewModel()
        setupUI()
    }

    //ui
    private fun setupUI() {
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    //view model
    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            Injection.provideViewModelFactory()
        ).get(MuseumViewModel::class.java)

        viewModel.museums.observe(this, renderMuseums)

    }

    //observers
    private val renderMuseums = Observer<List<Museum>> {
        adapter.update(it)
    }



    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }


}
