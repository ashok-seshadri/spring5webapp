package com.spring.training.spring5webapp.model.repositories;

import com.spring.training.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
