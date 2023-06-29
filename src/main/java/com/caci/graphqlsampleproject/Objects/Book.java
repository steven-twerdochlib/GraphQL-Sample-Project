package com.caci.graphqlsampleproject.Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.w3c.dom.ls.LSOutput;

public record Book (String id, String name, int pageCount, Status status, String authorId) {

    private static ArrayList<Book> books = new ArrayList<>( Arrays.asList(
            new Book("book-1", "Effective Java", 416, Status.PUBLISHED, "author-1"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, Status.NOT_PUBLISHED, "author-2"),
            new Book("book-3", "Down Under", 436, Status.PUBLISHED, "author-3")
    ));

    public static Book getById(String id) {
        return books.stream()
				.filter(book -> book.id().equals(id))
				.findFirst()
				.orElse(null);
    }
    
    public static List<Book> getByLargerPageCount(Integer minPageCount) {
        return (books.stream()
				.filter(book -> book.pageCount() >= minPageCount)).collect(Collectors.toList());
    }
    
    public static List<Book> getAllBooks() {
        return (books.stream().collect(Collectors.toList()));
    }
    
    public static Book saveBook(Book book) {
    	books.add(book);
		return book;
    }
}