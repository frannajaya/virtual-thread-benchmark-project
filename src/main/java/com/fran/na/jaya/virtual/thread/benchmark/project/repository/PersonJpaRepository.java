package com.fran.na.jaya.virtual.thread.benchmark.project.repository;

import com.fran.na.jaya.virtual.thread.benchmark.project.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long> {
  
}
