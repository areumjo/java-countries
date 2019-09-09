package com.areumjo.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
@RequestMapping("/population")

public class PopulationCountryController {

    // /population/size/{people}
    @GetMapping(value = "/size/{people}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByPopulation(@PathVariable int people)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList
                .findCountries(e -> e.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // /population/min
    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMinPopulation()
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList.countryList;
        rtnCountry.sort((c1, c2) -> ((int)(c1.getPopulation() - c2.getPopulation())));

        return new ResponseEntity<>(rtnCountry.get(0), HttpStatus.OK);
    }

    // /population/max
    @GetMapping(value = "/max",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByMaxPopulation()
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList.countryList;
        rtnCountry.sort((c1, c2) -> ((int)(c1.getPopulation() - c2.getPopulation())));

        return new ResponseEntity<>(rtnCountry.get(rtnCountry.size()-1), HttpStatus.OK);
    }

    // stretch goal /population/median
    @GetMapping(value = "/{median}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedianPopulation()
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList.countryList;
        rtnCountry.sort((c1, c2) -> ((int)(c1.getPopulation() - c2.getPopulation())));

        return new ResponseEntity<>(rtnCountry.get(rtnCountry.size()-1), HttpStatus.OK);
    }

}

