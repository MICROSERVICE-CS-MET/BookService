package com.metcs.bookservice.controller

import com.metcs.bookservice.domain.model.Book
import com.metcs.bookservice.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController (
    private val bookService:BookService
){
    @GetMapping("")
    suspend fun getAll():List<Book>{
        return bookService.getAll();
    }
    @PostMapping("")
    suspend fun save(@RequestBody book:Book):Book{
        return bookService.save(book);
    }
}