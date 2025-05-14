package telran.java57.bookpostgresql.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import telran.java57.bookpostgresql.model.Book;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class BookRepositoryImpl implements BookRepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public Stream<Book> findBookByAuthorsName(String name) {
        return Stream.empty();
    }

    @Override
    public Stream<Book> findBookByPublisherPublisherName(String publisher) {
        return Stream.empty();
    }

    @Override
    public void deleteByAuthorsName(String authorName) {

    }

    @Override
    public boolean existsById(String isbn) {
        return em.find(Book.class, isbn)!=null;
    }

    @Override
    public Book save(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(em.find(Book.class, isbn));
    }

    @Override
    public void deleteById(String isbn) {

    }
}
