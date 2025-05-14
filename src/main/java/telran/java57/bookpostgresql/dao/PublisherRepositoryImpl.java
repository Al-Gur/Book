package telran.java57.bookpostgresql.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import telran.java57.bookpostgresql.model.Publisher;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {
    @PersistenceContext
    EntityManager em;

//    @Query("select distinct p.publisherName from Book b join b.publisher p" +
//            " join b.authors a where a.name=?1")
    @Override
    public Stream<String> findPublisherByAuthor(String author) {
        return em.createQuery("select distinct b.publisher.publisherName from Book b join b.authors a" +
                        " where a.name = \"" + author + "\"")
                .getResultStream();
    }

    @Override
    public Optional<Publisher> findById(String publisher) {
        return Optional.ofNullable(em.find(Publisher.class, publisher));
    }

    @Override
    public Publisher save(Publisher publisher) {
        em.persist(publisher);
        return publisher;
    }
}
