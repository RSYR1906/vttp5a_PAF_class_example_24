package vttp.batch5.PAF.day24_in_class.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.PAF.day24_in_class.model.Book;
import vttp.batch5.PAF.day24_in_class.repo.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Boolean insertBook(Book book) {
        return bookRepo.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public Book getBookById(int bookId) {
        return bookRepo.getBookById(bookId);
    }

    public Boolean updateBook(Book book) {
        return bookRepo.updateBook(book);
    }

    public Boolean updateBookStatus(Book book) {
        return bookRepo.updateBookStatus(book);
    }
}
