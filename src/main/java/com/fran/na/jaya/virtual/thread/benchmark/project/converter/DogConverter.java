package com.fran.na.jaya.virtual.thread.benchmark.project.converter;

import com.fran.na.jaya.virtual.thread.benchmark.project.model.dto.DogDto;
import com.fran.na.jaya.virtual.thread.benchmark.project.model.entity.Dog;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DogConverter {

  DogDto toDto(Dog source);

  List<DogDto> toDto(List<Dog> source);
}
