package mk.ukim.finki.emt.emtlabs.model.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.emtlabs.model.Author;
import mk.ukim.finki.emt.emtlabs.model.BookCategory;

@Data
public class BookDto {
    private String name;

    private Long bookCategoryId;

    private Long authorId;

    private Integer availableCopies;

    private Long isbn;

    public BookDto() {
    }

    public BookDto(String name, Long bookCategoryId, Long authorId, Integer availableCopies, Long isbn) {
        this.name = name;
        this.bookCategoryId = bookCategoryId;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
        this.isbn = isbn;
    }
}
