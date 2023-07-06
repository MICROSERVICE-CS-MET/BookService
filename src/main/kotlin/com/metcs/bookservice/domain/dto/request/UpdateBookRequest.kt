package com.metcs.bookservice.domain.dto.request

import java.util.*

data class UpdateBookRequest(
    val id: UUID,
    var name:String,
    var description:String,
    var category: String,
    var pageCount: Int,
    var stock: Int,
    var price:Double
)
