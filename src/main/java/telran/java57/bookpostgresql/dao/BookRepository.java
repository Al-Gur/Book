package telran.java57.bookpostgresql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java57.bookpostgresql.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
