package com.datastax.examples.spring.webservice.controller;

import com.datastax.examples.spring.webservice.model.Person;
import com.datastax.examples.spring.webservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {

  @Autowired
  PersonRepository personRepository;

  @GetMapping("/persons")
  public ResponseEntity<List<Person>> getAllPersons() {
    try {
      List<Person> persons = personRepository.findAll();
      if (persons.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(persons, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/persons/{id}")
  public ResponseEntity<Person> getPersonById(@PathVariable("id") String user) {
    Optional<Person> personData = personRepository.findById(user);

    if (personData.isPresent()) {
      return new ResponseEntity<>(personData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/persons")
  public ResponseEntity<Person> createPerson(@RequestBody Person person) {
    try {
      Person _person = personRepository.save(new Person(person.getUsername(), person.getFirstname(), person.getLastname()));
      return new ResponseEntity<>(_person, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/persons/{id}")
  public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") String user) {
    try {
      personRepository.deleteById(user);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/persons")
  public ResponseEntity<HttpStatus> deleteAllPersons() {
    try {
      personRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
