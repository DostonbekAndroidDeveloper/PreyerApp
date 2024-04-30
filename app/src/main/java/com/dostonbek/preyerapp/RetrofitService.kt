package com.dostonbek.preyerapp

import com.dostonbek.preyer.model.Solat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{city}.json?key=e3eb838991bb27773e01b8ca9c5f89a3")
    fun getApi(@Path("city")city:String): Call<Solat>



    companion object {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
               // .addConverterFactory()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://muslimsalat.com")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}



