package com.hotel.project.hotelproject.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findBookByIsbnNumber( long isbnNumber );

}
