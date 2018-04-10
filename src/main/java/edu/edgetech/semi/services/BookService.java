package edu.edgetech.semi.services;

import edu.edgetech.semi.entities.Book;
import edu.edgetech.semi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> listAllbooks() {
        return bookRepository.findAll();
    }
    public Book saveBook(Book book) {
        bookRepository.save(book);
        return book;
    }
    public Iterable<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
}
