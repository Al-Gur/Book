package telran.java57.bookpostgresql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java57.bookpostgresql.dto.AuthorDto;
import telran.java57.bookpostgresql.dto.BookDto;
import telran.java57.bookpostgresql.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping("/book")
    public Boolean addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @GetMapping("/book/{isbn}")
    public BookDto findBookByIsbn(@PathVariable String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @DeleteMapping("/book/{isbn}")
    public BookDto removeBook(@PathVariable String isbn) {
        return bookService.removeBook(isbn);
    }

    @PutMapping("/book/{isbn}/title/{newTitle}")
    public BookDto updateBookTitle(@PathVariable String isbn, @PathVariable String newTitle) {
        return bookService.updateBookTitle(isbn, newTitle);
    }

    @GetMapping("/books/author/{author}")
    public BookDto[] findBooksByAuthor(@PathVariable String author) {
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/books/publisher/{publisher}")
    public BookDto[] findBooksByPublisher(@PathVariable String publisher) {
        return bookService.findBooksByPublisher(publisher);
    }

    @GetMapping("/authors/book/{isbn}")
    public AuthorDto[] findBookAuthors(@PathVariable String isbn) {
        return bookService.findBookAuthors(isbn);
    }

    @GetMapping("/publishers/author/{author}")
    public String[] findPublishersByAuthor(@PathVariable String author) {
        return bookService.findPublishersByAuthor(author);
    }
}
