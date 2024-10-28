package mk.ukim.finki.emt.emtlabs.service;

import mk.ukim.finki.emt.emtlabs.model.Author;
import mk.ukim.finki.emt.emtlabs.model.Country;
import mk.ukim.finki.emt.emtlabs.model.dto.AuthorDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll();

    Optional<Author> findById(Long id);

    Author save(String name, String surname, Long countryId,String biography, Date date);

    Optional<Author> save(AuthorDto authorDto);

    Author update(Long id, String name, String surname, Long countryId,String biography, Date date);

    Optional<Author> update(Long id, AuthorDto authorDto);

    Author delete(Long id);
}
