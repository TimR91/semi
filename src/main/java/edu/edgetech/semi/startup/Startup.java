package edu.edgetech.semi.startup;

import edu.edgetech.semi.entities.Book;
import edu.edgetech.semi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private BookService bookService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createBook("The Truth About PI", "anonymous", 628);
        createBook("The Fall of Reach", "various", 550);
        createBook("Splinter Cell", "Tom Clancy", 420);
        createBook("Fifteen Hours", "Warhammer", 211);
        createBook("Roadside Picnic", "A Russian Guy", 315);
    }

    private void createBook(String title, String author, int pages) {
        Book book = new Book(title, author, pages);
        bookService.saveBook(book);
    }

}
