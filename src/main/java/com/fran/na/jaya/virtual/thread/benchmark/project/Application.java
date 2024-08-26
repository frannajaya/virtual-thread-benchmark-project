package com.fran.na.jaya.virtual.thread.benchmark.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.fran.na.jaya"})
@EntityScan(basePackages = {"com.fran.na.jaya"})
@EnableJpaRepositories(basePackages = {"com.fran.na.jaya"})
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
