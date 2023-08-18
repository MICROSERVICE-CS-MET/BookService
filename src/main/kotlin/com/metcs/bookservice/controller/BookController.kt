package com.metcs.bookservice.controller

import com.metcs.bookservice.domain.dto.request.CreateBookRequest
import com.metcs.bookservice.domain.dto.request.UpdateBookRequest
import com.metcs.bookservice.domain.dto.response.BookResponse
import com.metcs.bookservice.domain.dto.response.PaginatedResponse
import com.metcs.bookservice.domain.mapper.BookMapper
import com.metcs.bookservice.service.BookService
import java.util.UUID
import org.mapstruct.factory.Mappers
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService
) {

    @GetMapping
    suspend fun getAll(
        @RequestParam("page")page: Int,
        @RequestParam("offset")offset: Int
    ): PaginatedResponse<BookResponse> {
        val converter = Mappers.getMapper(BookMapper::class.java)
        return converter.paginatedBookToPaginatedBookResponse(bookService.getAll(page, offset))
    }

    @GetMapping("/{id}")
    suspend fun getById(@PathVariable("id") id: UUID): BookResponse {
        val converter = Mappers.getMapper(BookMapper::class.java)
        val book = bookService.findById(id)
        return converter.bookToBookResponse(book)
    }

    @PostMapping
    suspend fun save(@RequestBody bookRequest: CreateBookRequest): BookResponse {
        val converter = Mappers.getMapper(BookMapper::class.java)
        val savedBook = bookService.save(converter.createRequestToBook(bookRequest))
        return converter.bookToBookResponse(savedBook)
    }

    @DeleteMapping("/{id}")
    suspend fun delete(@PathVariable("id")id: UUID): ResponseEntity<String> {
        bookService.delete(id)
        return ResponseEntity.ok("Book Deleted!")
    }

    @PatchMapping("")
    suspend fun update(@RequestBody updateBookRequest: UpdateBookRequest): BookResponse {
        val converter = Mappers.getMapper(BookMapper::class.java)
        val updatedBook = bookService.update(converter.updateBookRequestToBook(updateBookRequest))
        return converter.bookToBookResponse(updatedBook)
    }
}
