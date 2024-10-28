package mk.ukim.finki.emt.emtlabs.service;

import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import mk.ukim.finki.emt.emtlabs.model.dto.BookCategoryDto;

import java.util.List;
import java.util.Optional;

public interface BookCategoryService {
    List<BookCategory> findAll();
    Optional<BookCategory> findById(Long id);
    BookCategory save(String name);
    Optional<BookCategory> save(BookCategoryDto bookCategoryDto);
    BookCategory update(Long id, String name);
    void delete(Long id);
}
