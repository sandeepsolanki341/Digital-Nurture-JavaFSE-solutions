package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Loads the Spring IoC container from applicationContext.xml and exercises
 * dependency injection (Ex 1, 2, 5, 7) plus AOP logging (Ex 3, 8).
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println("Book found: " + bookService.findBook());
    }
}
