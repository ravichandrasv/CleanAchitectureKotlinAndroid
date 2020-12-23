package com.example.cleanarchitecturekotlin.presenter.framework

import com.example.cleanarchitecturekotlin.data.Museum
import com.example.cleanarchitecturekotlin.data.MuseumDataSource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MuseumRemoteDataSource(apiClient: ApiClient) : MuseumDataSource {

    private var call: Observable<MuseumResponse>? = null
    private val service = ApiClient.build()
    var disposable: Disposable? = null
    override fun retrieveMuseums(callback: OperationCallback<Museum>) {

        call = service?.museums()

        disposable = call?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    callback.onSuccess(it.data)
                }
                ,
                {t->
                    callback.onError(t.message)
                }
            )


    }

    override fun cancel() {
        call.let {it.toString()

        }
    }

}


