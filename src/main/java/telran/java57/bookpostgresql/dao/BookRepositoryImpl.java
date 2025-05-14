package telran.java57.bookpostgresql.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import telran.java57.bookpostgresql.model.Author;
import telran.java57.bookpostgresql.model.Book;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class BookRepositoryImpl implements BookRepository{
    @PersistenceContext
    EntityManager em;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    //@Query("select b from ")
    public Stream<Book> findBookByAuthorsName(String name) {
        return Stream.empty();
    }

    @Override
    public Stream<Book> findBookByPublisherPublisherName(String publisher) {
        return jdbcTemplate.query("select b.isbn from Book b where b.publisher_publisher_name = ?",
                (rs, rowNum)-> this.findById(rs.getString("isbn")).get(),
                        publisher)
                .stream();
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
        Book book = em.find(Book.class,isbn);
        if (book != null){
            em.remove(book);
        }
    }
}
