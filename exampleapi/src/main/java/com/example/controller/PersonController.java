package com.example.controller;

import com.example.pojo.PersonPojo;
import com.example.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;
    private static final Logger LOG = LogManager.getLogger(PersonController.class);
    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<PersonPojo> savePerson(@RequestBody PersonPojo person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.OK);
    }


    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<PersonPojo>> getAllPersons() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<PersonPojo> getById(@PathVariable long id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "", produces = "application/json")
    public ResponseEntity<Object> deleteUser(@RequestBody PersonPojo person) {
        personService.deletePerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
