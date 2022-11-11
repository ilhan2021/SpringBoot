package com.visionrent.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.visionrent.domain.Car;
import com.visionrent.dto.CarDTO;
@Mapper(componentModel = "spring")
public interface CarMapper {
	
	
	@Mapping(target="image" , ignore = true) // image fieldı bir tarafda String diğer tarafda ImageFile türünde old için ignore ediliyor
	Car carDTOToCar(CarDTO carDTO) ;
	
	//*************************************
	
 // TODO bakılacak
	List<CarDTO> map(List<Car> cars);
	
	// TODO  buraya metod yazılacak , getImageAsString()
	@Mapping(target="image" , ignore = true)
	CarDTO carToCarDTO(Car car);
}