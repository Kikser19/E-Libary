package mk.ukim.finki.emt.emtlabs.repository;

import mk.ukim.finki.emt.emtlabs.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
