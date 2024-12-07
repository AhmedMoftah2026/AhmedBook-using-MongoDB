package com.ahmed.mongodb_book.config;

import com.ahmed.mongodb_book.model.Author;
import com.ahmed.mongodb_book.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public void run(String... args) throws Exception {

        if (authorRepo.findAll().isEmpty()){
        Author author =new Author();
        author.setName("Ahmed");
        author.setEmail("Ahmed@gmail.com");
        author.setPhone("01055228899");


        Author author1 =new Author();
        author1.setName("Ali");
        author1.setEmail("Ali@gmail.com");
        author1.setPhone("01555228899");

        Author author2 =new Author();
        author2.setName("moh");
        author2.setEmail("moh@gmail.com");
        author2.setPhone("01666228899");

        authorRepo.insert(Arrays.asList(author,author1,author2));

    }}
}
