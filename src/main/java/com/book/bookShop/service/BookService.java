package com.book.bookShop.service;

import com.book.bookShop.model.Book;
import java.util.List;

public interface BookService {

  List<Book> getBooks();

  Book getBookbyIsbn(String isbn);

  boolean createBook(Book book);

  boolean updateBook(Book book);

  boolean deleteBook(String isbn);

}
