package com.book.bookShop.service;

import com.book.bookShop.integration.BookIntegration;
import com.book.bookShop.model.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bookServiceImp implements BookService {

  @Autowired
  private BookIntegration bookIntegration;

  @Override
  public List<Book> getBooks() {
    return bookIntegration.getBooks();
  }

  @Override
  public Book getBookbyIsbn(String isbn) {
    return bookIntegration.getBookbyIsbn(isbn);
  }

  @Override
  public boolean createBook(Book book) {
    return bookIntegration.createBook(book);
  }

  @Override
  public boolean updateBook(Book book) {
    return bookIntegration.updateBook(book);
  }

  @Override
  public boolean deleteBook(String isbn) {
    return bookIntegration.deleteBook(isbn);
  }
}
