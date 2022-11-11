package com.rentacar.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.rentacar.domain.Car;
import com.rentacar.dto.CarDTO;

@Mapper(componentModel = "spring")
public interface CarMapper {
	@Mapping(target = "image",ignore = true)
	Car carDTOToCar(CarDTO carDTO);
	
	
	
	List<CarDTO> map(List<Car> carList);
	
	
	@Mapping(target = "image",ignore = true)
	CarDTO carToCarDTO(Car car);
}
