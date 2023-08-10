package com.metcs.bookservice.repository

import com.metcs.bookservice.domain.model.Book
import kotlinx.coroutines.flow.Flow
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface BookRepository : CoroutineCrudRepository<Book, UUID> {
    suspend fun findAllBy(pageable: Pageable): Flow<Book>
}
