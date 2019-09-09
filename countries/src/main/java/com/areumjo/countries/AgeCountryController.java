package com.areumjo.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/age")

public class AgeCountryController {

    // /age/age/{age}
    @GetMapping(value = "/age/{age}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByAge(@PathVariable int age)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList
                .findCountries(e -> e.getMedianAge() >= age);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // /age/min
    @GetMapping(value = "/min",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByMinAge()
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList.countryList;
        rtnCountry.sort((c1, c2) -> ((int)(c1.getMedianAge() - c2.getMedianAge())));


        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
}
