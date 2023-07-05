package com.metcs.bookservice.service

import com.metcs.bookservice.domain.model.Book
import com.metcs.bookservice.repository.BookRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class BookService (
    private val bookRepository:BookRepository
    ){
    suspend fun getAll():List<Book>{
        val books=bookRepository.findAll().toList();
        return books;
    }
    suspend fun save(book: Book):Book{
        return  bookRepository.save(book);
    }
}