package com.metcs.bookservice.domain.dto.request

data class CreateBookRequest(
    var name: String,
    var description: String,
    var category: String,
    var pageCount: Int,
    var stock: Int,
    var price: Double
)
