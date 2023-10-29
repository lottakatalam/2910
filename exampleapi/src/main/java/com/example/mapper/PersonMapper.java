package com.example.mapper;

import com.example.entity.Person;
import com.example.pojo.PersonPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {
    public Person map(PersonPojo pojo) {
        Person p = new Person();
        p.setSocialSecurityNumber(pojo.getSocialSecurityNumber());
        p.setFirstNames(pojo.getFirstNames());
        p.setLastName(pojo.getLastName());
        p.setNationality(pojo.getNationality());
        p.setFirstLanguage(pojo.getFirstLanguage());
        p.setBirthDate(pojo.getBirthDate());
        p.setDeathDate(pojo.getDeathDate());
        p.setAddress(pojo.getAddress());
        return p;
    }
    
    public PersonPojo map(Person person){
        PersonPojo p = new PersonPojo();
        person.setSocialSecurityNumber(p.getSocialSecurityNumber());
        person.setFirstNames(p.getFirstNames());
        person.setLastName(p.getLastName());
        person.setNationality(p.getNationality());
        person.setFirstLanguage(p.getFirstLanguage());
        person.setBirthDate(p.getBirthDate());
        person.setDeathDate(p.getDeathDate());
        person.setAddress(p.getAddress());
        return p;
    }

    public List<PersonPojo> map(List<Person> persons) {
        return persons.stream().map(p -> map(p)).collect(Collectors.toList());
    }

}
