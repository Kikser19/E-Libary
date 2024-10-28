package mk.ukim.finki.emt.emtlabs.repository;

import mk.ukim.finki.emt.emtlabs.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
