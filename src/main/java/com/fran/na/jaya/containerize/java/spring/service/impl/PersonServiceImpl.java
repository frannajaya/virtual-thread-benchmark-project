package com.fran.na.jaya.containerize.java.spring.service.impl;

import com.fran.na.jaya.containerize.java.spring.entity.Person;
import com.fran.na.jaya.containerize.java.spring.model.PersonDto;
import com.fran.na.jaya.containerize.java.spring.repository.PersonJpaRepository;
import com.fran.na.jaya.containerize.java.spring.service.PersonService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonJpaRepository personJpaRepository;

  @Override
  public Person save(PersonDto personDto) {
    Person toBeSaved = new Person(personDto);
    return personJpaRepository.save(toBeSaved);
  }

  @Override
  public Person update(PersonDto personDto) {
    Person toBeSaved = getById(personDto.getId());
    if (Objects.nonNull(personDto.getName())) {
      toBeSaved.setName(personDto.getName());
    }
    if (Objects.nonNull(personDto.getAge())) {
      toBeSaved.setAge(personDto.getAge());
    }
    return personJpaRepository.save(toBeSaved);
  }

  @Override
  public Person getById(Long id) {
    return personJpaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No person found with the data id"));
  }

  @Override
  public Person deleteById(Long id) {
    Person toBeDeleted = personJpaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No person found with the data id"));

    personJpaRepository.delete(toBeDeleted);

    return toBeDeleted;
  }
}
