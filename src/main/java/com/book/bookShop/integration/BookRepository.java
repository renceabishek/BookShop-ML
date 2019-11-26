package com.book.bookShop.integration;

import com.book.bookShop.model.Book;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BookRepository extends JpaRepository<Book, String> {

    Book findBookByisbn(String isbn);

}
