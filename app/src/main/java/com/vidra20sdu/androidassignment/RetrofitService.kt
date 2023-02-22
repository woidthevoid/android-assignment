package com.vidra20sdu.androidassignment

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("/v3/a13796bc-ef8b-44d1-829b-f3c60ea31a85")
    fun getMovies(): Call<List<Movie>>

    companion object {
        var retrofitService:RetrofitService?=null

        fun getInstance():RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://run.mocky.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}