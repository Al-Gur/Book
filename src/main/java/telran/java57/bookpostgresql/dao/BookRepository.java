package telran.java57.bookpostgresql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java57.bookpostgresql.model.Author;
import telran.java57.bookpostgresql.model.Book;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findBooksByPublisher_PublisherName(String name);
    List<Book> findBooksByAuthorsContains(Set<Author> authors);

}
