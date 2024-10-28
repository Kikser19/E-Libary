package mk.ukim.finki.emt.emtlabs.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public BookCategory() {
    }

    public BookCategory(String name) {
        this.name = name;
    }
}
