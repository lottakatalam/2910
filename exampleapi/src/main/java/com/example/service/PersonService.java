package com.example.service;

import com.example.pojo.PersonPojo;

import java.util.List;

public interface PersonService {
    PersonPojo savePerson(PersonPojo Person);
    List<PersonPojo> getAll();
    PersonPojo getPersonById(long id);
    void deletePerson(PersonPojo id);
}
