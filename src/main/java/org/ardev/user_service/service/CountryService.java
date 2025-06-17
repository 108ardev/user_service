package org.ardev.user_service.service;

import org.ardev.user_service.model.entity.Country;

public interface CountryService {

    Country findCountryById(Long id);
}
