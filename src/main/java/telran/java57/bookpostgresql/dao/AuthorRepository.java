package telran.java57.bookpostgresql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java57.bookpostgresql.model.Author;

public interface AuthorRepository extends JpaRepository<Author,String> {
}
