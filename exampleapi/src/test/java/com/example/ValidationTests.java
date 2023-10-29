package com.example;

import com.example.exception.BadRequestException;
import com.example.pojo.PersonPojo;
import com.example.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


public class ValidationTests {

    PersonServiceImpl personService = new PersonServiceImpl();

    PersonPojo person = new PersonPojo();

    @BeforeEach
    public void setup(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        person.setBirthDate(LocalDate.parse("01-07-1976",formatter));
        person.setFirstNames("Lotta Katariina");
        person.setLastName("Lampola");
        person.setSocialSecurityNumber("010776-123D");
    }

    @ParameterizedTest
    @ValueSource(strings = {"","425555-123D","010795-214F","020896+YYYY","010799","jotainhöpöä"})
    public void testSocialSecurityNumberValidationWithInvalidInput(String ssnum){
        person.setSocialSecurityNumber(ssnum);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        person.setBirthDate(LocalDate.parse("01-07-1996",formatter));
        Assertions.assertThrows(BadRequestException.class,() -> {
            personService.savePerson(person);
        }, "BadRequestException was expected");

    }

    @ParameterizedTest
    @CsvSource({"13-11-1996,131196-123D", "13-11-1900,131100-123D", "01-01-1886,010186+123D","12-12-2000,121200A123D","01-05-2023,010523A123D"})
    public void testSocialSecurityNumberValidationWithValidInput(String birthDate, String ssnum){
        person.setSocialSecurityNumber(ssnum);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        person.setBirthDate(LocalDate.parse(birthDate,formatter));
        assertEquals(birthDate,personService.savePerson(person).getBirthDate().format(formatter));

    }

    @ParameterizedTest
    @ValueSource(strings = {"123","Häh`?","Ei kyll4 sov1 t!ma"})
    public void testNameWithInvalidInput(String name) {
        person.setLastName(name);
        person.setFirstNames(name);
        assertThrows(BadRequestException.class,() -> {
            personService.savePerson(person);
        }, "BadRequestException was expected");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Kaisa Marianne","Kaisa-Marianne Aino","Amin","Härkönen-Guevara","Guzenina","Bëyoncé"})
    public void testNameWithValidInput(String name) {
        person.setLastName(name);
        person.setFirstNames(name);
        assertEquals(name, personService.savePerson(person).getFirstNames());
    }

}
