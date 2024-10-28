package mk.ukim.finki.emt.emtlabs.repository.views;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.emtlabs.model.views.BooksPerCategoryMaterializedView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksPerCategoryMaterializedViewRepository extends JpaRepository<BooksPerCategoryMaterializedView ,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "Refresh materialized view public.books_per_categ",nativeQuery = true)
    void refreshMaterializedView();
}
