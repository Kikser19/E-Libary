package mk.ukim.finki.emt.emtlabs.service.impl;

import mk.ukim.finki.emt.emtlabs.model.Author;
import mk.ukim.finki.emt.emtlabs.model.Book;
import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import mk.ukim.finki.emt.emtlabs.model.dto.BookDto;
import mk.ukim.finki.emt.emtlabs.model.events.BookCreatedEvent;
import mk.ukim.finki.emt.emtlabs.model.exceptions.InvalidAuthorException;
import mk.ukim.finki.emt.emtlabs.model.exceptions.InvalidBookIdException;
import mk.ukim.finki.emt.emtlabs.repository.AuthorRepository;
import mk.ukim.finki.emt.emtlabs.repository.BookCategoryRepository;
import mk.ukim.finki.emt.emtlabs.repository.BookRepository;
import mk.ukim.finki.emt.emtlabs.repository.views.BooksPerCategoryMaterializedViewRepository;
import mk.ukim.finki.emt.emtlabs.service.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BooksPerCategoryMaterializedViewRepository booksPerCategoryMaterializedViewRepository;
    private final BookCategoryRepository bookCategoryRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BooksPerCategoryMaterializedViewRepository booksPerCategoryMaterializedViewRepository, BookCategoryRepository bookCategoryRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.booksPerCategoryMaterializedViewRepository = booksPerCategoryMaterializedViewRepository;
        this.bookCategoryRepository = bookCategoryRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(String name, Long bookCategoryId, Long authorId, Integer availableCopies, Long isbn) {
        Author a = this.authorRepository.findById(authorId).orElseThrow(InvalidAuthorException::new);
        BookCategory bookCategory = this.bookCategoryRepository.findById(bookCategoryId).get();
        Book b = new Book(name, bookCategory, a, availableCopies,isbn);

        this.bookRepository.save(b);
        this.refreshMaterializedView();
        this.applicationEventPublisher.publishEvent(new BookCreatedEvent(b));
        return Optional.of(b);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(InvalidAuthorException::new);
        BookCategory bookCategory = this.bookCategoryRepository.findById(bookDto.getBookCategoryId()).get();
        Book book = new Book(bookDto.getName(), bookCategory, author, bookDto.getAvailableCopies(), bookDto.getIsbn());
        this.bookRepository.save(book);
        this.refreshMaterializedView();
        this.applicationEventPublisher.publishEvent(new BookCreatedEvent(book));
        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, String name,Long bookCategoryId, Long authorId, Integer availableCopies, Long isbn) {
        Book b = this.findById(id).orElseThrow(InvalidBookIdException::new);
        Author a = this.authorRepository.findById(authorId).orElseThrow(InvalidAuthorException::new);
        BookCategory bookCategory = this.bookCategoryRepository.findById(bookCategoryId).get();
        b.setName(name);
        b.setIsbn(isbn);
        b.setAuthor(a);
        b.setBookCategory(bookCategory);
        b.setAvailableCopies(availableCopies);
        this.bookRepository.save(b);
        this.refreshMaterializedView();
        this.applicationEventPublisher.publishEvent(new BookCreatedEvent(b));
        return Optional.of(b);
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book b = this.findById(id).orElseThrow(InvalidBookIdException::new);
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(InvalidAuthorException::new);
        BookCategory bookCategory = this.bookCategoryRepository.findById(bookDto.getBookCategoryId()).get();
        b.setName(bookDto.getName());
        b.setAuthor(author);
        b.setBookCategory(bookCategory);
        b.setAvailableCopies(bookDto.getAvailableCopies());
        b.setIsbn(bookDto.getIsbn());
        this.bookRepository.save(b);
        this.refreshMaterializedView();
        this.applicationEventPublisher.publishEvent(new BookCreatedEvent(b));
        return Optional.of(b);
    }

    @Override
    public void delete(Long id) {
        Book b = this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        this.bookRepository.delete(b);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void refreshMaterializedView() {
        this.booksPerCategoryMaterializedViewRepository.refreshMaterializedView();
    }

    @Override
    public void markAsTaken(Long id) {
        Book b = this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        b.setAvailableCopies(b.getAvailableCopies() - 1);
        this.bookRepository.save(b);
    }

    @Override
    public List<Book> findByName(String name) {
        return this.bookRepository.findByNameContaining(name);
    }

}
