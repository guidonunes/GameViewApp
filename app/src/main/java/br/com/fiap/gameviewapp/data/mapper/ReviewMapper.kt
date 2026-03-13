package br.com.fiap.gameviewapp.data.mapper


import br.com.fiap.gameviewapp.data.remote.dto.ReviewDto
import br.com.fiap.gameviewapp.data.local.entity.ReviewEntity

fun ReviewDto.toEntity() = ReviewEntity(
    id = id,
    title = title,
    description = description,
    url = url
)