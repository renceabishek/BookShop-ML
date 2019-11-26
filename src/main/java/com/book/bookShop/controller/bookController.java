package com.book.bookShop.controller;

import com.book.bookShop.model.Book;
import com.book.bookShop.service.BookService;
import com.book.bookShop.service.bookServiceImp;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/rest")
public class bookController {

  @Autowired
  private BookService bookService;


  @RequestMapping(value = "/book", method = RequestMethod.GET)
  public ResponseEntity<List> getAlltheBooks(HttpServletResponse response) {
    HttpHeaders httpHeaders=new HttpHeaders();
    /*httpHeaders.set("Access-Control-Allow-Origin","http://localhost:4200");*/
    //response.addHeader("Access-Control-Allow-Origin","http://localhost:4200");
    return ResponseEntity.ok().body(bookService.getBooks());
  }

  @RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
  public Book getBookByIsbn(@PathVariable String isbn) {
    return bookService.getBookbyIsbn(isbn);
  }

  @RequestMapping(value = "/book", method = RequestMethod.PUT)
  public boolean updateBook(@RequestBody Book book) {
    return bookService.updateBook(book);
  }

  @RequestMapping(value = "/book", method = RequestMethod.POST)
  public boolean createBook(@RequestBody Book book) {
    return bookService.createBook(book);
  }

  @RequestMapping(value = "/book/{isbn}", method = RequestMethod.DELETE)
  public boolean deleteBook(@PathVariable String isbn) {
    return bookService.deleteBook(isbn);
  }

}
