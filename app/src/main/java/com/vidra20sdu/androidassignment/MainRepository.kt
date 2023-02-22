package com.vidra20sdu.androidassignment

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getMovies()
}