package com.sample.obs.OnlineBookStore.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.obs.OnlineBookStore.entity.Books;
import com.sample.obs.OnlineBookStore.service.BooksService;

@RestController
@RequestMapping("/api")
public class BooksController {
	@Autowired
	private BooksService service;
	
	@GetMapping("/books")
	public List<Books> listAllBooks() {
		List<Books> books = service.listAllBooks();
		return books;
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> retrieveBookById(@PathVariable("id") long id) {
		Books book = service.retrieveBookById(id);
		return ResponseEntity.ok().body(book);
	}
	
	@GetMapping("/books/store/{id}")
	public List<Books> listAllByStore(@PathVariable("id") long id) {
		List<Books> books = service.listBooksByStoreId(id);
		return books;
	}
	
	@GetMapping("/books/author/{author}")
	public List<Books> listByAuthor(@PathVariable("author") String author) {
		List<Books> books = service.listBooksByAuthor(author);
		return books;
	}
	
	@GetMapping("/books/category/{category}")
	public List<Books> listByCategory(@PathVariable("category") String category) {
		List<Books> books = service.listBooksByCategory(category);
		return books;
	}
	
	@GetMapping("/books/title/{title}")
	public List<Books> listByTitle(@PathVariable("title") String title) {
		List<Books> books = service.listBooksByTitleContaining(title);
		return books;
	}
	
	@GetMapping("/books/available")
	public List<Books> listByAvailability() {
		List<Books> books = service.listByAvailability();
		return books;
	}
	
	@PostMapping("/books")
	public ResponseEntity<Books> saveBookDetails(@RequestBody Books book) {
		Books b = service.saveBook(book);
		return ResponseEntity.ok().body(b);
	}
	
	@PutMapping("/books/price/{price}/{id}")
	@Transactional
	public ResponseEntity<String> updateBookPrice(@PathVariable("price") double price, @PathVariable("id") long id) {
		String str = service.updatePrice(price, id);
		return ResponseEntity.ok().body(str);
	}
	
	@PutMapping("/books/copies/{copies}/{id}")
	@Transactional
	public ResponseEntity<String> updateNoOfCopies(@PathVariable("copies") int copies, @PathVariable("id") long id) {
		String str = service.updateNoCopies(copies, id);
		return ResponseEntity.ok().body(str);
	}
	
	@PutMapping("/books/available/{available}/{id}")
	@Transactional
	public ResponseEntity<String> updateBookAvailability(@PathVariable("available") boolean available, @PathVariable("id") long id) {
		String str = service.updateAvailability(available, id);
		return ResponseEntity.ok().body(str);
	}
	
	@DeleteMapping("/books/delStore/{id}")
	@Transactional
	public ResponseEntity<String> removeBooksByStore(@PathVariable("id") long id) {
		String str = service.deleteBooksByStore(id);
		return ResponseEntity.ok().body(str);
	}
}
