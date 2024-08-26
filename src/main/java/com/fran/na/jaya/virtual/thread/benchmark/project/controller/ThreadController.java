package com.fran.na.jaya.virtual.thread.benchmark.project.controller;

import com.fran.na.jaya.virtual.thread.benchmark.project.constant.ApiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ThreadController {

  @GetMapping(ApiConstant.THREAD_NAME)
  public String getThreadName() {
    return Thread.currentThread().toString();
  }
}
