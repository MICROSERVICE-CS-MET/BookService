package com.metcs.bookservice.domain.dto.response

import org.springframework.data.annotation.Id
import java.util.*

data class BookResponse(
    @Id val id: UUID?=null,
    var name:String,
    var description:String,
    var category: String,
    var pageCount: Int,
    var stock: Int,
    var price:Double
)
