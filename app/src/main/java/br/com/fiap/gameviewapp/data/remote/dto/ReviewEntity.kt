package br.com.fiap.gameviewapp.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviews")
data class ReviewEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val url: String,
)