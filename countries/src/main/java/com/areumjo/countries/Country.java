package com.areumjo.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    // fields of object
    private static final AtomicLong counter = new AtomicLong();

    private long id;
    private String countryName;
    private int population;
    private int landSize;
    private int medianAge;

    // constructor
    public Country(String countryName, int population, int landSize, int medianAge) {
        this.id = counter.incrementAndGet();
        this.countryName = countryName;
        this.population = population;
        this.landSize = landSize;
        this.medianAge = medianAge;
    }

    // getters and setters
    public long getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandSize() {
        return landSize;
    }

    public void setLandSize(int landSize) {
        this.landSize = landSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    // methods

    @java.lang.Override
    public java.lang.String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", population=" + population +
                ", landSize=" + landSize +
                ", medianAge=" + medianAge +
                '}';
    }
}
