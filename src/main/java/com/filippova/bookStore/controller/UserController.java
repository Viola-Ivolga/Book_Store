package com.filippova.bookStore.controller;

import com.filippova.bookStore.entity.User;
import com.filippova.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
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
    public ModelAndView editUser(@PathVariable("id") long id, Model model) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userEdit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    // Deleting a book
    /*@RequestMapping("/deleteUser/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteById(id);
//        Book b=service.getBookById(id);
//        model.addAttribute("book",b);
        return "redirect:/available_books";*/
    //


    // ************************ from post

//    @PostMapping("/blog/{id}/edit")
//    public String blogPostUpdate(@PathVariable(value="id")long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
//        Post post = postRepository.findById(id).orElseThrow();
//        post.setTitle(title);
//        post.setAnons(anons);
//        post.setFull_text(full_text);
//        postRepository.save(post);
//        return "redirect:/blog";
//    }
//
//    @PostMapping("/blog/{id}/delete")
//    public String blogPostDelete(@PathVariable(value="id")long id, Model model){
//        Post post = postRepository.findById(id).orElseThrow();
//        postRepository.delete(post);
//        return "redirect:/blog";
//    }

}
