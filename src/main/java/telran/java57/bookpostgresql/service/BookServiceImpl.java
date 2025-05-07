package telran.java57.bookpostgresql.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import telran.java57.bookpostgresql.dao.AuthorRepository;
import telran.java57.bookpostgresql.dao.BookRepository;
import telran.java57.bookpostgresql.dao.PublisherRepository;
import telran.java57.bookpostgresql.dto.AuthorDto;
import telran.java57.bookpostgresql.dto.BookDto;
import telran.java57.bookpostgresql.dto.exceptions.NotFoundException;
import telran.java57.bookpostgresql.model.Author;
import telran.java57.bookpostgresql.model.Book;
import telran.java57.bookpostgresql.model.Publisher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService, CommandLineRunner {
    final BookRepository bookRepository;
    final AuthorRepository authorRepository;
    final PublisherRepository publisherRepository;
    final ModelMapper modelMapper;

    public BookDto newBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setIsbn(book.getIsbn());
        bookDto.setTitle(book.getTitle());
        Set<AuthorDto> authorDtos = new HashSet<>();
        book.getAuthors().forEach(author -> authorDtos.add(modelMapper.map(author, AuthorDto.class)));
        bookDto.setAuthors(authorDtos);
        bookDto.setPublisher(book.getPublisher().getPublisherName());
        return bookDto;
    }

    @Override
    public Boolean addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())) {
            return false;
        }
        //Publisher
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
                .orElse(publisherRepository.save(new Publisher(bookDto.getPublisher())));
        //Author
        Set<Author> authors = bookDto.getAuthors().stream()
                .map(authorDto -> authorRepository.findById(authorDto.getName())
                        .orElse(authorRepository.save(modelMapper.map(authorDto, Author.class))))
                .collect(Collectors.toSet());
        //Book
        Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher);
        bookRepository.save(book);
        return true;
    }

    @Override
    public BookDto findBookByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);
        return newBookDto(book);
    }

    @Override
    public BookDto removeBook(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);
        bookRepository.deleteById(isbn);
        return newBookDto(book);
    }

    @Override
    public BookDto updateBookTitle(String isbn, String newTitle) {
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);
        book.setTitle(newTitle);
        bookRepository.save(book);
        return newBookDto(book);
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
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);
        return book.getAuthors().stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .toArray(AuthorDto[]::new);
    }

    @Override
    public String[] findPublishersByAuthor(String author) {
        return new String[0];
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0 && authorRepository.count() == 0 && publisherRepository.count() == 0) {
            Publisher publisher = new Publisher("Springer");
            Author author = new Author("Pupkin", LocalDate.of(2000, 4, 1));
            Set<Author> setAuthors = new HashSet<>();
            setAuthors.add(author);
            Book book = new Book("1234", "Tales", setAuthors, publisher);
            publisherRepository.save(publisher);
            authorRepository.save(author);
            bookRepository.save(book);
        }
    }
}
