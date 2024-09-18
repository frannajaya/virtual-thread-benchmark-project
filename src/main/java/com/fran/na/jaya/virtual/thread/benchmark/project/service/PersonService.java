package com.fran.na.jaya.virtual.thread.benchmark.project.service;

import com.fran.na.jaya.virtual.thread.benchmark.project.entity.Person;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.PersonDto;

public interface PersonService {

  Person save(PersonDto personDto);

  Person update(PersonDto personDto);

  Person getById(Long id);

  Person deleteById(Long id);
}
