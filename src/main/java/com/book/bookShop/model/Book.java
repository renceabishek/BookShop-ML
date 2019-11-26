package com.book.bookShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

  @Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "isbn")
  private String isbn;
  @Column(name = "author")
  private String author;
  @Column(name = "title")
  private String title;
  @Column(name = "price")
  private double price;

  public Book() {

  }

  public Book(String isbn, String author, String title, double price) {
    this.isbn = isbn;
    this.author = author;
    this.title = title;
    this.price = price;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
