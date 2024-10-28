package mk.ukim.finki.emt.emtlabs.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;
    @Column(columnDefinition = "TEXT")
    private String biography;
    private Date dateOfBirth;

    public Author(String name, String surname, Country country, String biography, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
        this.dateOfBirth = dateOfBirth;
    }

    public Author() {
    }
}
