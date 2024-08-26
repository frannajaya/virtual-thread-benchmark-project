package com.fran.na.jaya.virtual.thread.benchmark.project.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SimplePageResponse<T> implements Serializable {

  @Serial
  private static final long serialVersionUID = -7411397183807979943L;

  private boolean hasNext;
  private boolean hasPrevious;
  private long size;
  private long currentPage;
  private List<T> results;
}
