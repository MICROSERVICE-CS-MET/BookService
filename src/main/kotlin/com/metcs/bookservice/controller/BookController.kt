package com.metcs.bookservice.controller

import com.metcs.bookservice.domain.dto.request.CreateBookRequest
import com.metcs.bookservice.domain.dto.request.UpdateBookRequest
import com.metcs.bookservice.domain.dto.response.BookResponse
import com.metcs.bookservice.domain.mapper.BookMapper
import org.mapstruct.factory.Mappers
import com.metcs.bookservice.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService,
) {

    @GetMapping("")
    suspend fun getAll(): List<BookResponse> {
        val converter = Mappers.getMapper(BookMapper::class.java)
        return converter.booksToBookResponse(bookService.getAll())
    }
    @GetMapping("/{id}")
    suspend fun getById(@PathVariable("id") id : UUID):BookResponse{
        val converter = Mappers.getMapper(BookMapper::class.java)
        val book=bookService.getById(id)
        return converter.bookToBookResponse(book)

    }

    @PostMapping("")
    suspend fun save(@RequestBody bookRequest: CreateBookRequest): BookResponse {
        val converter = Mappers.getMapper(BookMapper::class.java)
        val savedBook = bookService.save(converter.createRequestToBook(bookRequest))
        return converter.bookToBookResponse(savedBook)
    }
    @DeleteMapping("/{id}")
    suspend fun delete(@PathVariable("id")id:UUID):ResponseEntity<String>{
        bookService.delete(id)
        return ResponseEntity.ok("Book Deleted!")
    }

    @PatchMapping("")
    suspend fun update(@RequestBody updateBookRequest: UpdateBookRequest): BookResponse{
        val converter = Mappers.getMapper(BookMapper::class.java)
        val updatedBook = bookService.update(converter.updateBookRequestToBook(updateBookRequest))
        return converter.bookToBookResponse(updatedBook)

    }
}