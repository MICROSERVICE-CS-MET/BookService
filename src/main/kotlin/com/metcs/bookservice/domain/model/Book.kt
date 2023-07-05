package com.metcs.bookservice.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table
data class Book(
    @Id val id: UUID?=null,
    var name:String,
    var description:String,
    var category: String,
    var pageCount: Int,
    var stock: Int,
    var price:Double
)
