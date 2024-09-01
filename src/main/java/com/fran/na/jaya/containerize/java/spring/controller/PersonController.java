package com.fran.na.jaya.containerize.java.spring.controller;

import com.fran.na.jaya.containerize.java.spring.entity.Person;
import com.fran.na.jaya.containerize.java.spring.model.PersonDto;
import com.fran.na.jaya.containerize.java.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping("/api/person/{id}")
  public PersonDto getPersonById(@PathVariable("id") Long id) {
    Person person = personService.getById(id);
    return new PersonDto(person);
  }

  @PostMapping("/api/person")
  public PersonDto createPerson(@RequestBody PersonDto personDto) {
    Person person = personService.save(personDto);
    return new PersonDto(person);
  }

  @PutMapping("/api/person")
  public PersonDto updatePerson(@RequestBody PersonDto personDto) {
    Person person = personService.update(personDto);
    return new PersonDto(person);
  }

  @DeleteMapping("/api/person/{id}")
  public PersonDto deletePersonById(@PathVariable("id") Long id) {
    Person person = personService.deleteById(id);
    return new PersonDto(person);
  }
}
