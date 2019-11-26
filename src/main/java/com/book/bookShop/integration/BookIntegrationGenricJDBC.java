package com.book.bookShop.integration;

import com.book.bookShop.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

//@Repository
public class BookIntegrationGenricJDBC implements BookIntegration {

  String dbURL = "jdbc:mysql://localhost:3306/test";
  String username = "root";
  String password = "password";

  @Override
  public List<Book> getBooks() {
    List<Book> books=new ArrayList<>();
    Connection con =null;
    try{
      con = DriverManager.getConnection(dbURL, username, password);
      String sql="select isbn,author,title,price from books";
      PreparedStatement preparedStatement= con.prepareStatement(sql);
      ResultSet rs= preparedStatement.executeQuery();
      while(rs.next()){
        Book book=new Book();
        book.setIsbn(rs.getString("isbn"));
        book.setAuthor(rs.getString("author"));
        book.setTitle(rs.getString("title"));
        book.setPrice(rs.getDouble("price"));
        books.add(book);
      }
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      if(con!=null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return books;
  }

  @Override
  public Book getBookbyIsbn(String isbn) {
    Book book=null;
    Connection con=null;
    try{
      String sql= "select isbn,author,title,price from books where isbn=?";
      con = DriverManager.getConnection(dbURL,username,password);
      PreparedStatement pst=con.prepareStatement(sql);
      pst.setString(1,isbn);
      ResultSet rst=pst.executeQuery();
      while(rst.next()){
        book=new Book();
        book.setIsbn(rst.getString("isbn"));
        book.setAuthor(rst.getString("author"));
        book.setTitle(rst.getString("title"));
        book.setPrice(rst.getDouble("price"));
      }
    } catch (Exception e){
      e.printStackTrace();
    } finally {
      if (con!=null){
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return book;
  }

  @Override
  public boolean createBook(Book book) {
    Connection con=null;
    try{
      con = DriverManager.getConnection(dbURL,username,password);
      String sql="insert into books(isbn,author,title,price) values(?,?,?,?)";
      PreparedStatement pst=con.prepareStatement(sql);
      pst.setString(1,book.getIsbn());
      pst.setString(2,book.getAuthor());
      pst.setString(3,book.getTitle());
      pst.setDouble(4,book.getPrice());

      return pst.executeUpdate() > 0;

    }catch (Exception e){
      e.printStackTrace();
    } finally {
      if(con!=null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return false;
  }

  @Override
  public boolean updateBook(Book book) {
    Connection con=null;
    try{
      String sql="update books set author=?, title=?, price=? where isbn=?";
      con = DriverManager.getConnection(dbURL,username,password);
      PreparedStatement pst=con.prepareStatement(sql);
      pst.setString(1,book.getAuthor());
      pst.setString(2,book.getTitle());
      pst.setDouble(3,book.getPrice());
      pst.setString(4,book.getIsbn());

      return pst.executeUpdate()>0;

    } catch (Exception e){
      e.printStackTrace();
    } finally {
      if (con!=null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return false;
  }

  @Override
  public boolean deleteBook(String isbn) {
    Connection con=null;
    try {
      con= DriverManager.getConnection(dbURL,username,password);
      String sql="delete from books where isbn=?";
      PreparedStatement pst=con.prepareStatement(sql);
      pst.setString(1,isbn);
      return pst.executeUpdate()>0;

    } catch (Exception e){
      e.printStackTrace();
    } finally {
      if(con !=null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return false;
  }
}
