package vttp.batch5.PAF.day24_in_class.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vttp.batch5.PAF.day24_in_class.model.Book;
import vttp.batch5.PAF.day24_in_class.utils.Queries;

@Repository
public class BookRepo {

    @Autowired
    private JdbcTemplate template;

    public Boolean insertBook(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Queries.createBookSql, new String[] { "id" });
                ps.setString(1, book.getTitle());
                ps.setInt(2, book.getQuantity());
                return ps;
            }

        };

        int createdBookId = template.update(psc, keyHolder);
        if (createdBookId > 0) {
            System.out.println("Inserted book with ID: " + keyHolder.getKey().intValue());
            return true;
        }
        return false;
    }

    public List<Book> getAllBooks() {
        List<Book> books = template.query(Queries.getBooksSql, BeanPropertyRowMapper.newInstance(Book.class));
        return books;
    }

    public Book getBookById(int bookId) {
        Book book = template.queryForObject(Queries.getBookById, BeanPropertyRowMapper.newInstance(Book.class),
                bookId);

        return book;
    }

    public Boolean updateBook(Book book) {
        int Updated = template.update(Queries.updateBookById, book.getTitle(), book.getQuantity(), book.getId());
        if (Updated > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateBookStatus(Book book) {
        int Updated = template.update(Queries.updateBookStatusById, book.getIsActive(), book.getId());
        if (Updated > 0) {
            return true;
        }
        return false;
    }
}
