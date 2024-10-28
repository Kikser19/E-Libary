package mk.ukim.finki.emt.emtlabs.service;

import mk.ukim.finki.emt.emtlabs.model.Author;
import mk.ukim.finki.emt.emtlabs.model.Book;
import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import mk.ukim.finki.emt.emtlabs.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();

    Optional<Book> save(String name, Long bookCategoryId, Long authorId, Integer availableCopies, Long isbn);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> update(Long id, String name, Long bookCategoryId, Long authorId, Integer availableCopies, Long isbn);

    Optional<Book> update(Long id, BookDto bookDto);

    void delete(Long id);

    Optional<Book> findById(Long id);

    void refreshMaterializedView();

    void markAsTaken(Long id);

    List<Book> findByName(String name);
}
