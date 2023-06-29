package com.caci.graphqlsampleproject.Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Author (String id, String firstName, String lastName) {

    private static ArrayList<Author> authors = new ArrayList<>(Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson")
    ));

    public static Author getById(String id) {
        return authors.stream()
				.filter(author -> author.id().equals(id))
				.findFirst()
				.orElse(null);
    }
    
    public static List<Author> getAllAuthors() {
        return (authors.stream().collect(Collectors.toList()));
    }
}