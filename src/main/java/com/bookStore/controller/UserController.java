package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.User;
import com.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/available_users")
    public ModelAndView getAllBook() {
        List<User> list = userService.getAllUsers();
        ModelAndView m = new ModelAndView();
        m.setViewName("userList");
        m.addObject("user", list);
        return m;
    }

    @RequestMapping("/editUser/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "userEdit";
    }

    // Deleting a book
    /*@RequestMapping("/deleteUser/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteById(id);
//        Book b=service.getBookById(id);
//        model.addAttribute("book",b);
        return "redirect:/available_books";*/
    //}

}
