package mk.ukim.finki.emt.emtlabs.service.impl;

import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import mk.ukim.finki.emt.emtlabs.model.dto.BookCategoryDto;
import mk.ukim.finki.emt.emtlabs.repository.BookCategoryRepository;
import mk.ukim.finki.emt.emtlabs.service.BookCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }


    @Override
    public List<BookCategory> findAll() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public Optional<BookCategory> findById(Long id) {
        return bookCategoryRepository.findById(id);
    }

    @Override
    public BookCategory save(String name) {
        BookCategory bookCategory = new BookCategory(name);
        this.bookCategoryRepository.save(bookCategory);
        return bookCategory;
    }

    @Override
    public Optional<BookCategory> save(BookCategoryDto bookCategoryDto) {
        BookCategory bookCategory = new BookCategory(bookCategoryDto.getName());
        this.bookCategoryRepository.save(bookCategory);
        return Optional.of(bookCategory);
    }

    @Override
    public BookCategory update(Long id, String name) {
        BookCategory bookCategory = findById(id).get();
        bookCategory.setName(name);
        this.bookCategoryRepository.save(bookCategory);
        return bookCategory;
    }

    @Override
    public void delete(Long id) {
        BookCategory bookCategory = findById(id).get();
        this.bookCategoryRepository.delete(bookCategory);
    }
}
