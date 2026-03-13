package br.com.fiap.gameviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.gameviewapp.data.local.database.AppDatabase
import br.com.fiap.gameviewapp.data.remote.api.RetrofitClient
import br.com.fiap.gameviewapp.data.repository.ReviewRepository
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameViewAppTheme {

            }
        }
    }
}

