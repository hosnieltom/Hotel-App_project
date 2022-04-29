package com.hotel.project.hotelproject.book;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
public class BookService {
	
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks()
	{
		
		return bookRepository.findAll();
	}
	
	public void addNewBook( Book book)
	{
		Optional<Book> bookOptional = 
				bookRepository.findBookByIsbnNumber( book.getIsbnNumber() );
		if( bookOptional.isPresent() )
		{
			throw new IllegalStateException( "This ISBN number is taken" );
		}
		bookRepository.save( book );
	}
	
	public void deleteBook( long isbnNumber )
	{
		boolean exists = bookRepository.existsById( isbnNumber );
		if( !exists )
		{
			throw new IllegalStateException( "book with isbnNumber " + isbnNumber + " does not exists" );
		}
		
		bookRepository.deleteById( isbnNumber );
	}
	
	@Transactional
	public void updateBook( long bookId, long isbnNumber,
			int pageNumber, String author,
			String title,
			String location )
	{
		Book book = bookRepository.findById( bookId )
    			.orElseThrow( () -> new IllegalStateException(
    					"book with id " + bookId + " does not exists"));
		
		if( isbnNumber != 0 && 
				isbnNumber > 0 &&
				!Objects.equals(book.getIsbnNumber(), isbnNumber) )
		{
			book.setIsbnNumber( isbnNumber );
		}
		if( pageNumber != 0 &&
				pageNumber > 0 && 
				!Objects.equals( book.getPageNumber(), pageNumber ) )
		{
			book.setPageNumber( pageNumber );
			
		}
		
		if( author != null &&
				author.length() > 0 &&
				!Objects.equals( book.getAuthor(), author ) )
		{
			book.setAuthor( author );
		}
		
		if( title != null &&
				title.length() > 0 &&
				!Objects.equals(book.getTitle(), title ) )
		{
			book.setTitle( title );
		}
		
		if( location != null &&
				location.length() > 0 &&
				!Objects.equals( book.getLocation(), location ) )
		{
			book.setLocation( location );
		}
		
	}

}

