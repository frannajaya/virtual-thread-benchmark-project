package com.fran.na.jaya.virtual.thread.benchmark.project.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiConstant {

  public static final String ROOT = "/v1/virtual-thread-benchmark";

  public static final String DOG = ROOT + "/dog";
  public static final String DOG_ID = DOG + "/{id}";

  public static final String THREAD = ROOT + "/thread";
  public static final String THREAD_NAME = THREAD + "/name";
}
