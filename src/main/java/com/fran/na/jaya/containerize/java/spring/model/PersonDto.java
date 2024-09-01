package com.fran.na.jaya.containerize.java.spring.model;

import com.fran.na.jaya.containerize.java.spring.entity.Person;
import java.io.Serial;
import java.io.Serializable;

public class PersonDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -1833564477962853085L;

  private Long id;
  private String name;
  private Integer age;

  public PersonDto(Long id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public PersonDto(Person person) {
    this.id = person.getId();
    this.name = person.getName();
    this.age = person.getAge();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
