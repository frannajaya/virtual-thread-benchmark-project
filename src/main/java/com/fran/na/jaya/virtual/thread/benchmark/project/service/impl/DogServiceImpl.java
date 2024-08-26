package com.fran.na.jaya.virtual.thread.benchmark.project.service.impl;

import com.fran.na.jaya.virtual.thread.benchmark.project.model.dto.request.DogCreateRequestDto;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.entity.Dog;
import com.fran.na.jaya.virtual.thread.benchmark.project.repository.DogRepository;
import com.fran.na.jaya.virtual.thread.benchmark.project.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

  private final DogRepository dogRepository;

  @Override
  public Page<Dog> getDogsPageable(Pageable pageable) {
    return dogRepository.findAll(pageable);
  }

  @Override
  public Dog getDogById(Long id) throws NotFoundException {
    return dogRepository.findById(id).orElseThrow(NotFoundException::new);
  }

  @Override
  public Dog create(DogCreateRequestDto request) {
    Dog dog = new Dog();
    dog.setRacial(request.getRacial());
    dog.setColor(request.getColor());
    return dogRepository.save(dog);
  }
}
