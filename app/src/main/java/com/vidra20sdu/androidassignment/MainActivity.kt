package com.vidra20sdu.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vidra20sdu.androidassignment.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this,ViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)
        binding.movieview.adapter = adapter
        viewModel.movieList.observe(this, Observer{Log.d(TAG,"onCreate: $it")
        adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this,Observer{})
        viewModel.getAllMovies()
    }
}