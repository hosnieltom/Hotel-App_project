package com.hotel.project.hotelproject.book;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin 
@RequestMapping( path = "/books" )
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping
	public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@PostMapping
	public void addNewBook( @RequestBody Book book )
	{
		bookService.addNewBook( book);
	}
	
	@DeleteMapping( path = "{isbnNumber}" )
	public void deleteBook( @PathVariable( "isbnNumber" ) long isbnNumber )
	{
		bookService.deleteBook( isbnNumber );
	}
	
	@PutMapping( path = "{bookId}" )
	public void updateBook( @PathVariable( "bookId" ) long bookId,
			@RequestParam( required = false ) long isbnNumber,
			@RequestParam( required = false ) int pageNumber,
			@RequestParam( required = false ) String author,
			@RequestParam( required = false ) String title,
			@RequestParam( required = false ) String location )
	{
		bookService.updateBook( bookId, isbnNumber, pageNumber, author, title, location );
		
	}

}
