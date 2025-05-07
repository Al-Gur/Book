package telran.java57.bookpostgresql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;
import telran.java57.bookpostgresql.dto.AuthorDto;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "isbn")
public class Book {
    @Id
    String isbn;
    String title;
    @ManyToMany
    Set<Author> authors;
    @ManyToOne
    Publisher publisher;
}
