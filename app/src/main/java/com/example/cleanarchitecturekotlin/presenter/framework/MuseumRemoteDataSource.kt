package com.example.cleanarchitecturekotlin.presenter.framework

import com.example.cleanarchitecturekotlin.datas.Museum
import com.example.cleanarchitecturekotlin.datas.MuseumDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MuseumRemoteDataSource(apiClient: ApiClient) : MuseumDataSource {

    private var call: Call<MuseumResponse>? = null
    private val service = ApiClient.build()

    override fun retrieveMuseums(callback: OperationCallback<Museum>) {

        call = service?.museums()
        call?.enqueue(object : Callback<MuseumResponse> {
            override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<MuseumResponse>,
                response: Response<MuseumResponse>
            ) {
                response.body()?.let {
                    if (response.isSuccessful && (it.isSuccess())) {
                        callback.onSuccess(it.data)
                    } else {
                        callback.onError(it.msg)
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}