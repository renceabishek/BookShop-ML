package com.book.bookShop.integration;

import com.book.bookShop.model.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookIntegrationJdbcTemplate implements BookIntegration {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Book> getBooks() {
    return jdbcTemplate.query("select isbn,author,title,price from books", (rs, rowNum) ->
        new Book(rs.getString("isbn"), rs.getString("author"),
            rs.getString("title"), rs.getDouble("price")));
  }

  @Override
  public Book getBookbyIsbn(String isbn) {
    return (Book) jdbcTemplate.queryForObject(
        "select isbn,author,title,price from books where isbn = ?",
        new Object[]{isbn},
        (rs, rowNum) ->
            new Book(
                rs.getString("isbn"), rs.getString("author"),
                rs.getString("title"), rs.getDouble("price")
            )
    );
  }

  @Override
  public boolean createBook(Book book) {
    int createBook = jdbcTemplate
        .update("insert into books(isbn,author,title,price) values(?,?,?,?)",
            book.getIsbn(), book.getAuthor(), book.getTitle(), book.getPrice());
    return createBook > 0;
  }

  @Override
  public boolean updateBook(Book book) {
    int updatebook = jdbcTemplate.update("update books set author=?, title=?, price=? where isbn=?",
        book.getAuthor(), book.getTitle(), book.getPrice(), book.getIsbn());
    return updatebook > 0;

  }

  @Override
  public boolean deleteBook(String isbn) {
    int deleteBook = jdbcTemplate.update("delete from books where isbn=?", isbn);
    return deleteBook > 0;
  }
}
