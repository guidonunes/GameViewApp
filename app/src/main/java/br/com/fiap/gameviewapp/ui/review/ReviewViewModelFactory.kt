package br.com.fiap.gameviewapp.ui.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.gameviewapp.data.repository.ReviewRepository

class ReviewViewModelFactory(
    private val repository: ReviewRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReviewViewModel::class.java)) {
            return ReviewViewModel(repository) as T
        }
        throw IllegalArgumentException("unknown ViewModel")
    }
}