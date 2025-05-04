package telran.books.book.service;

import org.springframework.stereotype.Service;
import telran.books.book.dto.AuthorDto;
import telran.books.book.dto.BookDto;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public boolean addBook(BookDto bookDto) {
        return false;
    }

    @Override
    public BookDto findBookByIsbn(String isbn) {
        return null;
    }

    @Override
    public BookDto removeBook(String isbn) {
        return null;
    }

    @Override
    public BookDto updateBookTitle(String isbn, String newTitle) {
        return null;
    }

    @Override
    public BookDto[] findBooksByAuthor(String author) {
        return new BookDto[0];
    }

    @Override
    public BookDto[] findBooksByPublisher(String publisher) {
        return new BookDto[0];
    }

    @Override
    public AuthorDto[] findBookAuthors(String isbn) {
        return new AuthorDto[0];
    }

    @Override
    public String[] findPublishersByAuthor(String author) {
        return new String[0];
    }

    @Override
    public AuthorDto removeAuthor(String author) {
        return null;
    }
}
