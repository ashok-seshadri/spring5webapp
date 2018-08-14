package com.spring.training.spring5webapp.model.bootstrap;

import com.spring.training.spring5webapp.model.Author;
import com.spring.training.spring5webapp.model.Book;
import com.spring.training.spring5webapp.model.Publisher;
import com.spring.training.spring5webapp.model.repositories.AuthorRepository;
import com.spring.training.spring5webapp.model.repositories.BookRepository;
import com.spring.training.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public AppBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {


        Publisher himPublisher = new Publisher();
        himPublisher.setName("Himalayan publishers");
        himPublisher.setAddress("Himalayan mountains");
        publisherRepository.save(himPublisher);
        Publisher jaicoPublisher = new Publisher();
        jaicoPublisher.setName("JAICO");
        jaicoPublisher.setAddress("USA");
        publisherRepository.save(jaicoPublisher);
        Author rajMal = new Author("Rajiv", "Malhotra");

        Book breakingIndia = new Book("Breaking India", "1234");
        breakingIndia.setPublisher(himPublisher);
        rajMal.getBooks().add(breakingIndia);
        breakingIndia.getAuthors().add(rajMal);
        authorRepository.save(rajMal);

        bookRepository.save(breakingIndia);

        Author robShar = new Author("Robin", "Sharma");
        Book monkFerrari = new Book("The Monk who sold his Ferrari", "1235");
        monkFerrari.setPublisher(jaicoPublisher);
        robShar.getBooks().add(monkFerrari);
        monkFerrari.getAuthors().add(robShar);
        authorRepository.save(robShar);

        bookRepository.save(monkFerrari);
    }
}
