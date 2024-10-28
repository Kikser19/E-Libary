package mk.ukim.finki.emt.emtlabs.web.rest;

import mk.ukim.finki.emt.emtlabs.model.Author;
import mk.ukim.finki.emt.emtlabs.model.Book;
import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import mk.ukim.finki.emt.emtlabs.model.dto.AuthorDto;
import mk.ukim.finki.emt.emtlabs.model.dto.BookDto;
import mk.ukim.finki.emt.emtlabs.service.AuthorService;
import mk.ukim.finki.emt.emtlabs.service.BookCategoryService;
import mk.ukim.finki.emt.emtlabs.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    List<Author> findAll() {
        return authorService.listAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto){
        return this.authorService.save(authorDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.authorService.delete(id);
        if (this.authorService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> edit(@PathVariable Long id,@RequestBody AuthorDto authorDto) {
        return this.authorService.update(id,authorDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
