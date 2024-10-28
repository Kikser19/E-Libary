package mk.ukim.finki.emt.emtlabs.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorDto {
   private String name;
   private String surname;
   private Long countryId;
   private String biography;
   private Date dateOfBirth;

    public AuthorDto(String name, String surname, Long countryId, String biography, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
        this.biography = biography;
        this.dateOfBirth = dateOfBirth;
    }

    public AuthorDto() {
    }
}
