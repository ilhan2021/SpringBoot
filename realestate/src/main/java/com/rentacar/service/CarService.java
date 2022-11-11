package com.rentacar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rentacar.domain.Car;
import com.rentacar.domain.ImageFile;
import com.rentacar.dto.CarDTO;
import com.rentacar.exception.BadRequestException;
import com.rentacar.exception.ConflictException;
import com.rentacar.exception.ResourceNotFoundException;
import com.rentacar.exception.message.ErrorMessages;
import com.rentacar.mapper.CarMapper;
import com.rentacar.repository.CarRepository;

@Service
public class CarService {

	private CarRepository carRepository;

	private ImageFileService imageFileService;

	private CarMapper carMapper;

	@Autowired
	public CarService(CarRepository carRepository, ImageFileService imageFileService, CarMapper carMapper) {
		super();
		this.carRepository = carRepository;
		this.imageFileService = imageFileService;
		this.carMapper = carMapper;
	}

	public void saveCar(String imageId, CarDTO carDTO) {

		ImageFile imageFile = imageFileService.findImageById(imageId);

		int countImage = carRepository.countImageById(imageId);

		if (countImage > 0) {
			throw new ConflictException(ErrorMessages.RECEPABININ_EXCEPTIONU);
		}

		Car car = carMapper.carDTOToCar(carDTO);

		Set<ImageFile> images = new HashSet<>();

		images.add(imageFile);

		car.setImage(images);

		carRepository.save(car);

	}

	public List<CarDTO> getAllCars() {

		List<CarDTO> carDTOs = carMapper.map(carRepository.findAll());

		return carDTOs;
	}

	public Page<CarDTO> getAllCarsWithPage(Pageable pageable) {

		Page<Car> carPages = carRepository.findAll(pageable);

		return carPages.map(new Function<Car, CarDTO>() {
			@Override
			public CarDTO apply(Car car) {
				return carMapper.carToCarDTO(car);
			}
		});

	}

	public void deleteCarById(Long id) {
		Car car = carRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE, id)));

		carRepository.delete(car);
	}

	public void updateCarById(Long id, CarDTO carDTO) {
		Car car = carRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE, id)));

		boolean carBuilt = car.getBuiltIn();
		
		if (carBuilt) {
			throw new BadRequestException(ErrorMessages.BAD_REQUEST_EXCEPTION);
		}

		car.setAge(carDTO.getAge());
		car.setAirConditioning(carDTO.getAirConditioning());
		car.setBuiltIn(carDTO.getBuiltIn());
		car.setDoors(carDTO.getDoors());
		car.setFuelType(carDTO.getFuelType());
		car.setLuggage(carDTO.getLuggage());
		car.setModel(carDTO.getModel());
		car.setPricePerHour(carDTO.getPricePerHour());
		car.setSeats(carDTO.getSeats());
		car.setTransmission(carDTO.getTransmission());

	//	car = carMapper.carDTOToCar(carDTO);  çalışmıyor yani update etmiyor post mapping yapıyor

		carRepository.save(car);
	}

}
