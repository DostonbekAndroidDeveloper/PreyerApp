package com.dostonbek.preyerapp

import android.content.Context
import com.dostonbek.preyer.model.Solat
import com.dostonbek.preyerapp.model.Item
import retrofit2.Call
import retrofit2.Response

class SalatPresenter(context:Context) {
    val salatView = context as SalatView
    fun getDataFromApi(city:String){
        RetrofitService.create()
            .getApi(city)
            .enqueue(object :retrofit2.Callback<Solat>{
                override fun onResponse(call: Call<Solat>, response: Response<Solat>) {
salatView.onDataCompleteFromApi(response.body()?.items?.get(0)as Item)
                }

                override fun onFailure(call: Call<Solat>, t: Throwable) {
                    salatView.onDataErrorFromApi(t)
                }

            })

    }
}