package telran.java57.bookpostgresql.dao;

import telran.java57.bookpostgresql.model.Book;

import java.util.Optional;
import java.util.stream.Stream;

public interface BookRepository {

    Stream<Book> findBookByAuthorsName(String name);

    Stream<Book> findBookByPublisherPublisherName(String publisher);

    void deleteByAuthorsName(String authorName);

    boolean existsById(String isbn);

    Book save(Book book);

    Optional<Book> findById(String isbn);

    void deleteById(String isbn);
}
