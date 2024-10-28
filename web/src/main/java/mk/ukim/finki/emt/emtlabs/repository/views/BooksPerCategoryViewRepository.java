package mk.ukim.finki.emt.emtlabs.repository.views;
import mk.ukim.finki.emt.emtlabs.model.views.BooksPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksPerCategoryViewRepository
extends JpaRepository<BooksPerCategoryView, Long> {
}
