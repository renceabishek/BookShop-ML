package com.book.bookShop.integration;

import com.book.bookShop.model.Book;
import java.util.List;

public interface BookIntegration {

  List<Book> getBooks();

  Book getBookbyIsbn(String isbn);

  boolean createBook(Book book);

  boolean updateBook(Book book);

  boolean deleteBook(String isbn);

}
