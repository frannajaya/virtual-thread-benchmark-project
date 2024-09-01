package com.fran.na.jaya.containerize.java.spring.service;

import com.fran.na.jaya.containerize.java.spring.entity.Person;
import com.fran.na.jaya.containerize.java.spring.model.PersonDto;

public interface PersonService {

  Person save(PersonDto personDto);

  Person update(PersonDto personDto);

  Person getById(Long id);

  Person deleteById(Long id);
}
