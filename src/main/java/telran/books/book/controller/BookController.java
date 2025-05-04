package telran.books.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import telran.books.book.dto.BookDto;
import telran.books.book.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping("/book")
    public boolean addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }







}
