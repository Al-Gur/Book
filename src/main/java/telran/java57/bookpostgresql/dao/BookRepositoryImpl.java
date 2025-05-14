package telran.java57.bookpostgresql.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import telran.java57.bookpostgresql.model.Book;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Stream<Book> findBookByAuthorsName(String name) {
        return em.createQuery("select b from Book b join b.authors a where a.name = \"" + name + "\"")
                .getResultStream();
    }

    @Override
    public Stream<Book> findBookByPublisherPublisherName(String publisher) {
        return em.createQuery("select b from Book b where b.publisher.publisherName = \"" + publisher + "\"")
                .getResultStream();
    }

    @Override
    public void deleteByAuthorsName(String authorName) {
// no usages
    }

    @Override
    public boolean existsById(String isbn) {
        return em.find(Book.class, isbn) != null;
    }

    @Override
    public Book save(Book book) {
        deleteById(book.getIsbn());
        em.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(em.find(Book.class, isbn));
    }

    @Override
    public void deleteById(String isbn) {
        Book book = em.find(Book.class, isbn);
        if (book != null) {
            em.remove(book);
        }
    }
}
