package mk.ukim.finki.emt.emtlabs.service.impl;

import mk.ukim.finki.emt.emtlabs.model.Country;
import mk.ukim.finki.emt.emtlabs.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emt.emtlabs.repository.CountryRepository;
import mk.ukim.finki.emt.emtlabs.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country save(String name, String continent) {
        return this.countryRepository.save(new Country(name, continent));
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country c = this.findById(id);
        c.setName(name);
        c.setContinent(continent);
        return this.countryRepository.save(c);
    }

    @Override
    public Country delete(Long id) {
        Country c = this.findById(id);
        this.countryRepository.delete(c);
        return c;
    }
}
