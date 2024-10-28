package mk.ukim.finki.emt.emtlabs.service.impl;

import mk.ukim.finki.emt.emtlabs.model.Author;
import mk.ukim.finki.emt.emtlabs.model.Country;
import mk.ukim.finki.emt.emtlabs.model.dto.AuthorDto;
import mk.ukim.finki.emt.emtlabs.model.exceptions.InvalidAuthorException;
import mk.ukim.finki.emt.emtlabs.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emt.emtlabs.repository.AuthorRepository;
import mk.ukim.finki.emt.emtlabs.repository.CountryRepository;
import mk.ukim.finki.emt.emtlabs.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(String name, String surname, Long countryId,String biography, Date date) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        return this.authorRepository.save(new Author(name,surname,country, biography, date));
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountryId()).orElseThrow(InvalidCountryIdException::new);
        Author a = new Author(authorDto.getName(),authorDto.getSurname(),country,authorDto.getBiography(),authorDto.getDateOfBirth());
        this.authorRepository.save(a);
        return Optional.of(a);
    }

    @Override
    public Author update(Long id, String name, String surname, Long countryId,String biography, Date date) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        Author a = this.findById(id).get();
        a.setName(name);
        a.setSurname(surname);
        a.setCountry(country);
        a.setBiography(biography);
        a.setDateOfBirth(date);
        return this.authorRepository.save(a);
    }

    @Override
    public Optional<Author> update(Long id, AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountryId()).orElseThrow(InvalidCountryIdException::new);
        Author a = this.findById(id).get();
        a.setBiography(authorDto.getBiography());
        a.setCountry(country);
        a.setDateOfBirth(authorDto.getDateOfBirth());
        a.setName(authorDto.getName());
        a.setSurname(authorDto.getSurname());
        a.setCountry(country);
        return Optional.of(this.authorRepository.save(a));
    }

    @Override
    public Author delete(Long id) {
        Author a = this.findById(id).get();
        this.authorRepository.delete(a);
        return a;
    }
}
