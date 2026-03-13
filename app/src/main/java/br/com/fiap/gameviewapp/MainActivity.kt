package br.com.fiap.gameviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import br.com.fiap.gameviewapp.data.local.database.AppDatabase
import br.com.fiap.gameviewapp.data.remote.api.RetrofitClient
import br.com.fiap.gameviewapp.data.repository.ReviewRepository
import br.com.fiap.gameviewapp.ui.review.ReviewListScreen
import br.com.fiap.gameviewapp.ui.review.ReviewViewModel
import br.com.fiap.gameviewapp.ui.review.ReviewViewModelFactory
import br.com.fiap.gameviewapp.ui.theme.GameViewAppTheme

class MainActivity : ComponentActivity() {

    private val api by lazy {
        RetrofitClient().getReviewApi()
    }

    private val dao by lazy {
        AppDatabase.getDatabase(applicationContext).reviewDao()
    }

    private val repository by lazy {
        ReviewRepository(api, dao)
    }

    private val viewModel: ReviewViewModel by viewModels {
        ReviewViewModelFactory(repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameViewAppTheme {
                ReviewListScreen(viewModel)
            }
        }
    }
}

