package com.caci.graphqlsampleproject.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caci.graphqlsampleproject.Objects.Author;
import com.caci.graphqlsampleproject.Objects.Book;
import com.caci.graphqlsampleproject.Objects.Status;



@RestController
public class QueryController {
	
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }
    
    @QueryMapping
    public List<Book> getAllBooks() {
        return Book.getAllBooks();
    }
    
    @QueryMapping
    public List<Author> getAllAuthors() {
        return Author.getAllAuthors();
    }
    
    @QueryMapping
    public List<Book> bookByMinPageCount(@Argument Integer minPageCount) {
        return Book.getByLargerPageCount(minPageCount);
    }
    
    @MutationMapping
    public Book addBook(
    	@Argument String id,
        @Argument String name,
        @Argument Integer pageCount,
        @Argument Status status,
        @Argument String authorId) {
      var book = new Book(id, name, pageCount, status, authorId);
      return Book.saveBook(book);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}

