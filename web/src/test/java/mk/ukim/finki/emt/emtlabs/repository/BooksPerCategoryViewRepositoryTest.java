package mk.ukim.finki.emt.emtlabs.repository;

import mk.ukim.finki.emt.emtlabs.model.views.BooksPerCategoryView;
import mk.ukim.finki.emt.emtlabs.repository.views.BooksPerCategoryViewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksPerCategoryViewRepositoryTest {

    @Autowired
    private BooksPerCategoryViewRepository booksPerCategoryViewRepository;

    @Test
    public void testFindAll() {
        List<BooksPerCategoryView> list =
                this.booksPerCategoryViewRepository.findAll();
        Assert.assertEquals(2, list.size());
    }
}
