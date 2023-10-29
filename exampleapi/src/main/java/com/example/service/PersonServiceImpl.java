package com.example.service;

import com.example.entity.Person;
import com.example.exception.BadRequestException;
import com.example.exception.NotFoundException;
import com.example.mapper.PersonMapper;
import com.example.pojo.PersonPojo;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonRepository personRepository;

    public PersonPojo savePerson(PersonPojo person) {

        validatePerson(person);
        /*If JPA-repositories used:
        Person saved = personRepository.save(person);
        return personMapper.map(saved);*/
        return person;
    }


    @Override
    public List<PersonPojo> getAll() {
        return personMapper.map(personRepository.findAll());
    }

    @Override
    public PersonPojo getPersonById(long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent())
            return personMapper.map(person.get());
        else
            throw new NotFoundException("Henkilö ei löytynyt rekisteristä");
    }

    @Override
    public void deletePerson(PersonPojo person) {
        //first should check if person is found from register and then delete
        personRepository.delete(personMapper.map(person));
    }
    public void validatePerson(PersonPojo person){
        validateSocialSecurityNumber(person.getSocialSecurityNumber(), person.getBirthDate());
        validateName(person.getFirstNames());
        validateName(person.getLastName());
        /*TODO: rest of validation:
        validateNationality(person.getNationality());
        validateLanguage(person.getFirstLanguage());
        validateAddress(person.getAddress());
        validateDate(person.getBirthDate());
        validateDate(person.getDeathDate());*/
    }
    private void validateSocialSecurityNumber(String socialSecurityNumber, LocalDate birthDate) {

        if(socialSecurityNumber.length() != 11)
            throw  new BadRequestException("Invalid social security number");

        String regexForDate = "^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])\\d{2}$";
        if(!socialSecurityNumber.substring(0,6).matches(regexForDate))
            throw new BadRequestException("The first six digits describing birth date are invalid");

        String regexForCentury = "[-+A]";
        if(!socialSecurityNumber.substring(6,7).matches(regexForCentury))
            throw new BadRequestException("The character describing century of birth is invalid");


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        String formattedDate = birthDate.format(formatter);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDate2 = birthDate.format(formatter2).substring(4,6);
        String correctCharacter = formattedDate2.matches("18") ? "\\+" : formattedDate2.matches("19") ? "-" : "A";

        if(!(socialSecurityNumber.substring(0,6).matches(formattedDate)) || !(socialSecurityNumber.substring(6,7).matches(correctCharacter)))
            throw new BadRequestException("Social security number does not match the given birth date");

        //TODO: checking for the last four characters in the social security number

    }

    private void validateName(String name){
        if (!name.matches("^[\\p{L}\\s-]+$"))
            throw new BadRequestException("Invalid name");
    }

}
