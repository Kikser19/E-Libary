package mk.ukim.finki.emt.emtlabs.service;

import mk.ukim.finki.emt.emtlabs.model.Country;

import java.util.List;

public interface CountryService {
    Country findById(Long id);

    List<Country> listAll();

    Country save(String name, String continent);

    Country update(Long id, String name, String continent);

    Country delete(Long id);
}
