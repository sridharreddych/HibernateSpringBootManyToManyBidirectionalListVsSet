package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("===================================================");
            System.out.println("Populate database and remove a book (List case) ...");            
            System.out.println("===================================================");
            bookstoreService.persistAuthorWithBooksAndRemoveOneBookList();
            
            System.out.println("\n");
            System.out.println("==================================================");
            System.out.println("Populate database and remove a book (Set case) ...");
            System.out.println("==================================================");
            bookstoreService.persistAuthorWithBooksAndRemoveOneBookSet();
        };
    }
}

/*
 * 
 * 
 * Prefer Set Instead of List in @ManyToMany Associations

Description: This is a Spring Boot example of removing rows in case of a bidirectional @ManyToMany using List, respectively Set. The conclusion is that Set is much better! This applies to unidirectional as well!

Key points:

using Set is much more efficent than List
 * 
 * 
 */
