package com.library.repository;

import org.springframework.stereotype.Repository;

/**
 * Data access for books. Annotation-based configuration (Ex 6) uses @Repository;
 * the same bean is also declared in applicationContext.xml for the XML-based exercises.
 */
@Repository
public class BookRepository {

    public String getBook() {
        return "Clean Code by Robert C. Martin";
    }
}
