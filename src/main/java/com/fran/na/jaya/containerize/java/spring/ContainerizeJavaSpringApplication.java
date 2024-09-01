package com.fran.na.jaya.containerize.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.fran.na.jaya.containerize.java.spring")
@ComponentScan(basePackages = {"com.fran.na.jaya.containerize.java.spring"})
@EntityScan("com.fran.na.jaya.containerize.java.spring.entity")
@SpringBootApplication
public class ContainerizeJavaSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(ContainerizeJavaSpringApplication.class, args);
  }

}
