package com.metcs.bookservice.repository

import com.metcs.bookservice.domain.model.Book
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface BookRepository : CoroutineCrudRepository<Book,UUID>{
}