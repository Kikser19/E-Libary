package mk.ukim.finki.emt.emtlabs.web.rest;

import mk.ukim.finki.emt.emtlabs.model.Book;
import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import mk.ukim.finki.emt.emtlabs.model.dto.BookCategoryDto;
import mk.ukim.finki.emt.emtlabs.model.dto.BookDto;
import mk.ukim.finki.emt.emtlabs.service.BookCategoryService;
import mk.ukim.finki.emt.emtlabs.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/categories")
public class BookCategoryRestController {
    private final BookCategoryService bookCategoryService;

    public BookCategoryRestController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    List<BookCategory> findAll() {
        return bookCategoryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<BookCategory> save(@RequestBody BookCategoryDto bookCategoryDto){
        return this.bookCategoryService.save(bookCategoryDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookCategoryService.delete(id);
        if (this.bookCategoryService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
