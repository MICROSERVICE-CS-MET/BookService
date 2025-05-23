package com.metcs.bookservice.domain.mapper

import com.metcs.bookservice.domain.dto.request.CreateBookRequest
import com.metcs.bookservice.domain.dto.request.UpdateBookRequest
import com.metcs.bookservice.domain.dto.response.BookResponse
import com.metcs.bookservice.domain.dto.response.PaginatedResponse
import com.metcs.bookservice.domain.model.Book
import org.mapstruct.Mapper

@Mapper
interface BookMapper {
    fun bookToBookResponse(book: Book): BookResponse
    fun booksToBookResponse(books: List<Book>): List<BookResponse>
    fun createRequestToBook(bookDto: CreateBookRequest): Book
    fun paginatedBookToPaginatedBookResponse(books: PaginatedResponse<Book>): PaginatedResponse<BookResponse>
    fun updateBookRequestToBook(updateBookRequest: UpdateBookRequest): Book
}
