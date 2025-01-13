package vttp.batch5.PAF.day24_in_class.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.PAF.day24_in_class.model.Book;
import vttp.batch5.PAF.day24_in_class.repo.BookRepo;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok().body(bookRepo.getAllBooks());
    }

    @GetMapping("/{bookid}")
    public ResponseEntity<Book> getBookById(@PathVariable("book-id") Integer bookId) {
        return ResponseEntity.ok().body(bookRepo.getBookById(bookId));
    }

    @PostMapping("")
    public ResponseEntity<Boolean> createBook(@RequestBody Book book) {
        Boolean bCreated = bookRepo.insertBook(book);

        return ResponseEntity.ok().body(bCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
        Boolean bUpdated = bookRepo.updateBook(book);

        return ResponseEntity.ok().body(bUpdated);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Boolean> updateBookStatus(@PathVariable("id") Integer id, @RequestBody Book book) {
        Boolean bUpdated = bookRepo.updateBookStatus(book);

        return ResponseEntity.ok().body(bUpdated);
    }

}
