package com.fran.na.jaya.virtual.thread.benchmark.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadCheckerController {

  @GetMapping("/api/thread")
  public String getThreadRunning() {
    Thread thread = Thread.currentThread();
    return String.valueOf(thread);
  }
}
