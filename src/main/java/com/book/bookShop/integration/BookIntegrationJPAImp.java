package com.book.bookShop.integration;

import com.book.bookShop.model.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class BookIntegrationJPAImp implements BookIntegration {


  @Autowired
  private BookRepository bookRepository;

  @Override
  public List<Book> getBooks() {

    return bookRepository.findAll();
  }

  @Override
  public Book getBookbyIsbn(String isbn) {

    return bookRepository.findBookByisbn(isbn);
  }

  @Override
  public boolean createBook(Book book) {

    return bookRepository.save(book) != null;

  }

  @Override
  public boolean updateBook(Book book) {
    return bookRepository.save(book) != null;
  }

  @Override
  public boolean deleteBook(String isbn) {

    bookRepository.deleteById(isbn);
    return true;
  }
}
