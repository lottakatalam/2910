package com.example.pojo;

import com.example.entity.Address;
import com.example.entity.Language;
import com.example.entity.Nation;
import java.time.LocalDate;

public class PersonPojo {
    private String socialSecurityNumber;
    private String firstNames;
    private String lastName;
    private Nation nationality;
    private Language firstLanguage;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Address address;

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Nation getNationality() {
        return nationality;
    }

    public void setNationality(Nation nationality) {
        this.nationality = nationality;
    }

    public Language getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(Language firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
