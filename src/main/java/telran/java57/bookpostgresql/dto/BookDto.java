package telran.java57.bookpostgresql.dto;

import lombok.Getter;
import telran.java57.bookpostgresql.model.Book;

import java.util.HashSet;
import java.util.Set;

@Getter
public class BookDto {
    String isbn;
    String title;
    Set<AuthorDto> authors;
    String publisher;

    public BookDto(Book book) {
        isbn = book.getIsbn();
        title = book.getTitle();
        authors = new HashSet<>();
        book.getAuthors().forEach(author -> authors.add(new AuthorDto(author)));
        publisher = book.getPublisher().getPublisherName();
    }
}
