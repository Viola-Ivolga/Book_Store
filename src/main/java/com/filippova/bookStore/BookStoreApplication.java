package com.filippova.bookStore;

import com.filippova.bookStore.entity.Book;
import com.filippova.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

	@SpringBootApplication
	public class BookStoreApplication {

		public static void main(String[] args) {
			SpringApplication.run(BookStoreApplication.class, args);
		}


		// ******* to add data to db **********//
		@Autowired
		BookService bookService;

		@Bean
		public CommandLineRunner initialCreate( ) {
			return(args) ->{
				Book b01 = new Book(1, "Effective Java", "Joshua Bloch","120");

				bookService.save(b01);

				Book b02 = new Book(2, "Thinking in Java", "Bruce Eckel","150");

				bookService.save(b02);

				Book b03 = new Book(2, "Java: The Complete Reference", "Herbert Schildt","150");

				bookService.save(b03);



			};
		}}
