package br.com.fiap.gameviewapp.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val BASE_URL = "http://10.0.2.2:8080/api/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getReviewApi(): ReviewApi{
        return retrofitFactory.create(ReviewApi::class.java)
    }
}