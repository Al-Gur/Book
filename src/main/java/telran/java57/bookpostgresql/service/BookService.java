package telran.java57.bookpostgresql.service;

import telran.java57.bookpostgresql.dto.AuthorDto;
import telran.java57.bookpostgresql.dto.BookDto;

public interface BookService {
    Boolean addBook(BookDto bookDto);

    BookDto findBookByIsbn(String isbn);

    BookDto removeBook(String isbn);

    BookDto updateBookTitle(String isbn, String newTitle);

    BookDto[] findBooksByAuthor(String author);

    BookDto[] findBooksByPublisher(String publisher);

    AuthorDto[] findBookAuthors(String isbn);

    String[] findPublishersByAuthor(String author);

    AuthorDto removeAuthor(String author);
}
