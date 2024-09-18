package com.fran.na.jaya.virtual.thread.benchmark.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.fran.na.jaya.virtual.thread.benchmark.project")
@ComponentScan(basePackages = {"com.fran.na.jaya.virtual.thread.benchmark.project"})
@EntityScan("com.fran.na.jaya.virtual.thread.benchmark.project.entity")
@SpringBootApplication
public class VirtualThreadBenchmarkProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(VirtualThreadBenchmarkProjectApplication.class, args);
  }

}
