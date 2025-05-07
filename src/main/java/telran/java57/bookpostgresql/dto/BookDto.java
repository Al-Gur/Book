package telran.java57.bookpostgresql.dto;

import lombok.Getter;
import lombok.Setter;
import telran.java57.bookpostgresql.model.Book;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class BookDto {
    String isbn;
    String title;
    Set<AuthorDto> authors;
    String publisher;
}
