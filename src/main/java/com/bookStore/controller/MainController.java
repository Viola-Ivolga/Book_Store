package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookService;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "bookRegister";
    }

    // Method to return all books from the db on the web browser
    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book> list = service.getAllBook();
        ModelAndView m = new ModelAndView();
        m.setViewName("bookList");
        m.addObject("book",list);
        return m;
    }
    // Method to save the update/edit
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        service.save(b);
        return "redirect:/available_books";

    }
    @GetMapping("/my_books")
    public String getMyBooks( Model model)
    {
        List<MyBookList>list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b=service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";

    }
    // Method to edit  a book detail
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = service.getBookById(id);
        model.addAttribute("book",b);
        return"bookEdit";
    }
    // Deleting a book
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
//        Book b=service.getBookById(id);
//        model.addAttribute("book",b);
        return "redirect:/available_books";
    }

}
