package br.com.fiap.gameviewapp.data.remote.api


import br.com.fiap.gameviewapp.data.remote.dto.ReviewDto
import retrofit2.http.GET

interface ReviewApi {

    @GET("reviews")
    suspend fun getReviews(): List<ReviewDto>

}