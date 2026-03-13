package br.com.fiap.gameviewapp.ui.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.gameviewapp.data.repository.ReviewRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ReviewViewModel(
    private val repository: ReviewRepository
): ViewModel() {

    val reviews = repository.reviews.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(
            stopTimeoutMillis = 5_000
        ),
        initialValue = emptyList()
    )

    init {
        update()
    }

    fun update() {
        viewModelScope.launch {
            repository.updateReviews()
        }
    }

}