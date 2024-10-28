package mk.ukim.finki.emt.emtlabs.repository;

import mk.ukim.finki.emt.emtlabs.model.Author;
import mk.ukim.finki.emt.emtlabs.model.Book;
import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import mk.ukim.finki.emt.emtlabs.model.dto.BookDto;
import mk.ukim.finki.emt.emtlabs.model.views.BooksPerCategoryMaterializedView;
import mk.ukim.finki.emt.emtlabs.model.views.BooksPerCategoryView;
import mk.ukim.finki.emt.emtlabs.repository.views.BooksPerCategoryMaterializedViewRepository;
import mk.ukim.finki.emt.emtlabs.service.AuthorService;
import mk.ukim.finki.emt.emtlabs.service.BookCategoryService;
import mk.ukim.finki.emt.emtlabs.service.BookService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookPerCategoryAdd {

    @Autowired
    private BooksPerCategoryMaterializedViewRepository booksPerCategoryMaterializedViewRepository;

    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Test
    public void testCreateNewProduct() {
        List<BooksPerCategoryMaterializedView> list1 = this.booksPerCategoryMaterializedViewRepository.findAll();
        Author author = this.authorService.listAll().get(0);
        BookDto bookDto = new BookDto("Kikser",this.bookCategoryService.findAll().get(0).getId(), author.getId(), 10,1212343L);
        this.bookService.save(bookDto);
        List<BooksPerCategoryMaterializedView> list2 = this.booksPerCategoryMaterializedViewRepository.findAll();
    }

    @Test
    public void editProduct() {
        List<BooksPerCategoryMaterializedView> list1 = this.booksPerCategoryMaterializedViewRepository.findAll();
        Book b = bookService.listAll().get(0);
        Author author = this.authorService.listAll().get(0);
        BookDto bookDto = new BookDto("Najnova",this.bookCategoryService.findAll().get(0).getId(), author.getId(), 10, 1212343L);
        this.bookService.update(b.getId(), bookDto);
        List<BooksPerCategoryMaterializedView> list2 = this.booksPerCategoryMaterializedViewRepository.findAll();
    }
}
