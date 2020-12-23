package com.example.cleanarchitecturekotlin.presenter.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecturekotlin.R
import com.example.cleanarchitecturekotlin.data.Museum
import com.example.cleanarchitecturekotlin.presenter.viewmodel.MuseumViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_museum.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MuseumActivity : BaseActivity() {

    private lateinit var adapter: MuseumAdapter
    private val viewModel: MuseumViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        setupViewModel()
        setupUI()
    }

    private fun setupUI() {
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {

        viewModel.museums.observe(this, renderMuseums)


    }

    private val renderMuseums = Observer<List<Museum>> {
        val abs: Observable<List<Museum>> = Observable.just(it)
        abs.observeOn(AndroidSchedulers.mainThread())
            .doOnNext { progress_circular.visibility = View.VISIBLE }
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                progress_circular.visibility = View.GONE
                adapter.update(it)


            }

    }


    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }


}
