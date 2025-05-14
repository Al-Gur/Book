package telran.java57.bookpostgresql.dao;

import telran.java57.bookpostgresql.model.Publisher;

import java.util.Optional;
import java.util.stream.Stream;

public interface PublisherRepository {

    Stream<String> findPublisherByAuthor(String author);

    Optional<Publisher> findById(String publisher);

    Publisher save(Publisher publisher);
}
