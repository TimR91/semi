package edu.edgetech.semi.controllers;

import edu.edgetech.semi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    public BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books", bookService.listAllbooks());
        return "books";
    }
    @RequestMapping(value = "/books/title/{title}", method = RequestMethod.GET)
    public String listByTitle(@PathVariable String title, Model model) {
        model.addAttribute("books", bookService.findByTitle(title));
        return "books";
    }

}
