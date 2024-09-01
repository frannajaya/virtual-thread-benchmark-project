package com.fran.na.jaya.containerize.java.spring.repository;

import com.fran.na.jaya.containerize.java.spring.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long> {
  
}
