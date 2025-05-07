package telran.java57.bookpostgresql.dto;

import lombok.Getter;
import telran.java57.bookpostgresql.model.Author;

import java.time.LocalDate;

@Getter
public class AuthorDto {
    String name;
    LocalDate birthDate;

    public AuthorDto(Author author) {
        name=author.getName();
        birthDate=author.getBirthDate();
    }
}
