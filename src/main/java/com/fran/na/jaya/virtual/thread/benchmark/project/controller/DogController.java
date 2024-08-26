package com.fran.na.jaya.virtual.thread.benchmark.project.controller;

import com.fran.na.jaya.virtual.thread.benchmark.project.constant.ApiConstant;
import com.fran.na.jaya.virtual.thread.benchmark.project.converter.DogConverter;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.dto.DogDto;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.dto.request.DogCreateRequestDto;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.dto.response.SimplePageResponse;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.entity.Dog;
import com.fran.na.jaya.virtual.thread.benchmark.project.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DogController {

  private final DogService dogService;
  private final DogConverter dogConverter;

  @GetMapping(ApiConstant.DOG)
  public SimplePageResponse<DogDto> getDogsPageable(
      @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
  ) {
    Page<Dog> resultPage = dogService.getDogsPageable(pageable);
    return SimplePageResponse.<DogDto>builder()
        .hasNext(resultPage.hasNext())
        .hasPrevious(resultPage.hasPrevious())
        .size(resultPage.getSize())
        .currentPage(resultPage.getNumber())
        .results(dogConverter.toDto(resultPage.getContent()))
        .build();
  }

  @GetMapping(ApiConstant.DOG_ID)
  public DogDto getDogById(
      @PathVariable("id") Long id
  ) throws NotFoundException {
    return dogConverter.toDto(dogService.getDogById(id));
  }

  @PostMapping(ApiConstant.DOG)
  public DogDto createDog(
      @RequestBody DogCreateRequestDto request
  ) throws NotFoundException {
    return dogConverter.toDto(dogService.create(request));
  }
}
