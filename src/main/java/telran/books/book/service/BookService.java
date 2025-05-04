package telran.books.book.service;

import telran.books.book.dto.AuthorDto;
import telran.books.book.dto.BookDto;

public interface BookService {
    boolean addBook(BookDto bookDto);

    BookDto findBookByIsbn(String isbn);

    BookDto removeBook(String isbn);

    BookDto updateBookTitle(String isbn, String newTitle);

    BookDto[] findBooksByAuthor(String author);

    BookDto[] findBooksByPublisher(String publisher);

    AuthorDto[] findBookAuthors(String isbn);

    String[] findPublishersByAuthor(String author);
}
