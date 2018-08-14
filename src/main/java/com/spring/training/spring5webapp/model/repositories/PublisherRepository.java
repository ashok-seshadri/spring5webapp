package com.spring.training.spring5webapp.model.repositories;

import com.spring.training.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
