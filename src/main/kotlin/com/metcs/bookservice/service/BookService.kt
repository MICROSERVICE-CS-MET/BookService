package com.metcs.bookservice.service

import com.metcs.bookservice.domain.dto.response.PaginatedResponse
import com.metcs.bookservice.domain.model.Book
import com.metcs.bookservice.exception.NotFoundException
import com.metcs.bookservice.repository.BookRepository
import kotlinx.coroutines.flow.toList
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    suspend fun getAll(page: Int, offset: Int): PaginatedResponse<Book> {
        return bookPaginate(page, bookRepository.findAllBy(PageRequest.of(page, offset)).toList(), offset)
    }
    suspend fun findById(id: UUID): Book {
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
    private suspend fun bookPaginate(currentPage: Int, books: List<Book>, offset: Int): PaginatedResponse<Book> {
        val bookList = books.toList()
        val pageCount = bookRepository.count() / offset
        return PaginatedResponse(currentPage, bookList.count(), pageCount, books)
    }
}
