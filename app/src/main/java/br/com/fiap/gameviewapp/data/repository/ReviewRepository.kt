package br.com.fiap.gameviewapp.data.repository


import br.com.fiap.gameviewapp.data.local.dao.ReviewDao
import br.com.fiap.gameviewapp.data.mapper.toEntity
import br.com.fiap.gameviewapp.data.remote.api.ReviewApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReviewRepository(
    private val api: ReviewApi,
    private val dao: ReviewDao
) {

    val reviews = dao.getReviews()

    suspend fun updateReviews() {
        withContext(Dispatchers.IO) {
            try {
                val remoteReviews = api.getReviews()
                dao.insertAll(
                    reviews = remoteReviews.map { reviewDto ->
                        reviewDto.toEntity()
                    })
            } catch (e: Exception) {
                // Falhou internet → mantém cache
            }
        }
    }
}