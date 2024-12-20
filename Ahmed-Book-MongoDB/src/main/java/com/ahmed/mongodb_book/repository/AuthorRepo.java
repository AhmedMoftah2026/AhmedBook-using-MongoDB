package com.ahmed.mongodb_book.repository;

import com.ahmed.mongodb_book.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends MongoRepository<Author,String> {
    @Query(value= "{email:'?0'}" , fields="{'email' : 1}")
    Author findAuthorByEmail (String email);

}
