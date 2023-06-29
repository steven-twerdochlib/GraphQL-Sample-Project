package com.caci.graphqlsampleproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caci.graphqlsampleproject.Objects.Book;



@RestController
public class RestRequestsController {
	
	@Autowired
	public QueryController queryController;
	
	@GetMapping("/")
	public Book getBook(String bookId) {
		System.out.println(bookId);
		return queryController.bookById(bookId);
	}
	
}
