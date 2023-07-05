package com.metcs.bookservice.service

import com.metcs.bookservice.domain.model.Book
import com.metcs.bookservice.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class BookService (
    private val bookRepository:BookRepository
    ){
    suspend fun getAll():Flow<Book>{
        val books=bookRepository.findAll();
        return books;
    }
    suspend fun save(book: Book):Book{
        return  bookRepository.save(book);
    }
}