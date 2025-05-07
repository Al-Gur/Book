package telran.java57.bookpostgresql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java57.bookpostgresql.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
