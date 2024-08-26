package com.fran.na.jaya.virtual.thread.benchmark.project.service;

import com.fran.na.jaya.virtual.thread.benchmark.project.model.dto.request.DogCreateRequestDto;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.entity.Dog;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DogService {

  Page<Dog> getDogsPageable(Pageable pageable);

  Dog getDogById(Long id) throws NotFoundException;

  Dog create(DogCreateRequestDto request);
}
