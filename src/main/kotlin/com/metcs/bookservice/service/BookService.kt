package com.metcs.bookservice.service

import com.metcs.bookservice.domain.model.Book
import com.metcs.bookservice.exception.NotFoundException
import com.metcs.bookservice.repository.BookRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    // TODO CHANGE WITH FLOW AND PAGINATION
    suspend fun getAll(): List<Book> {
        return bookRepository.findAll().toList()
    }
    suspend fun getById(id: UUID): Book {
        return bookRepository.findById(id) ?: throw NotFoundException("Book not found")
    }

    suspend fun save(book: Book): Book {
        return bookRepository.save(book)
    }
    suspend fun delete(id: UUID) {
        bookRepository.deleteById(id)
    }
    suspend fun update(book: Book): Book {
        return bookRepository.save(book)
    }
}
