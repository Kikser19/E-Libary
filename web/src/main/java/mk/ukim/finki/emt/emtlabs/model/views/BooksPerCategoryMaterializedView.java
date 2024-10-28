package mk.ukim.finki.emt.emtlabs.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("select * from public.books_per_categ")
@Immutable
public class BooksPerCategoryMaterializedView {
    @Id
    @Column(name = "id")
    private Long categoryId;

    @Column(name = "numbooks")
    private Integer numBooks;

}
