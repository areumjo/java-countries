package com.areumjo.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")

public class CountryController
{
    // localhost:8080/data/names/all
    @GetMapping(value = "/names/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // /names/start/{letter}
    @GetMapping(value = "/names/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList
                .findCountries(e -> e.getCountryName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountry.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // /names/size/{number}
    @GetMapping(value = "/names/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByLength(@PathVariable int number)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList
                .findCountries(e -> e.getCountryName().length() >= number);
        rtnCountry.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // /population/size/{people}
    @GetMapping(value = "/population/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByPopulation(@PathVariable int people)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList
                .findCountries(e -> e.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

//    // /population/min
//    @GetMapping(value = "/population/min",
//                produces = {"application/json"})
//    public ResponseEntity<?> getCountryByMinPopulation()
//    {
//        ArrayList<Country> rtnCountry = CountriesApplication.ourCountryList
//                .findCountries(e -> e.getPopulation().math.min());
//        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
//    }

}
