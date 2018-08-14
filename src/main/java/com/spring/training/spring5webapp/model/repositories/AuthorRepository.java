package com.spring.training.spring5webapp.model.repositories;

import com.spring.training.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
