package mk.ukim.finki.emt.emtlabs.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private BookCategory bookCategory;
    @ManyToOne
    private Author author;
    private Integer availableCopies;
    private Long isbn;

    public Book(String name, BookCategory bookCategory, Author author, Integer availableCopies, Long isbn) {
        this.name = name;
        this.bookCategory = bookCategory;
        this.author = author;
        this.availableCopies = availableCopies;
        this.isbn = isbn;
    }

    public Book() {

    }
}
