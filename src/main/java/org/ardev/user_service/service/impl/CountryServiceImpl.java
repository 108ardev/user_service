package org.ardev.user_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.ardev.user_service.model.entity.Country;
import org.ardev.user_service.repository.CountryRepository;
import org.ardev.user_service.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country findCountryById(Long id) {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Country not found"));
    }
}
