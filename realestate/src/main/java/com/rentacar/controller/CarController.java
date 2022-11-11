package com.rentacar.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rentacar.dto.CarDTO;
import com.rentacar.dto.response.ResponseMessage;
import com.rentacar.dto.response.VRResponse;
import com.rentacar.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	private CarService carService;
	@Autowired
	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	// save
	@PostMapping("/admin/{imageId}/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> saveCar(@PathVariable("imageId")String imageId,
											@Valid @RequestBody CarDTO carDTO){
		carService.saveCar(imageId,carDTO);
		VRResponse response=new VRResponse(ResponseMessage.CAR_SAVE_RESPONSE,true);
		return ResponseEntity.ok(response);
	}
	
	// get all cars
	@GetMapping("/visitors/all")
	public ResponseEntity<List<CarDTO>> getAllCars(){
	List<CarDTO> carDtoList=carService.getAllCars();
	return ResponseEntity.ok(carDtoList);
	}
	
	// page 
	@GetMapping("/visitors/page")
	public ResponseEntity<Page<CarDTO>> getAllWithPage(@RequestParam("page") int page,
														@RequestParam("size") int size,
														@RequestParam("sort") String prop, // hangi sutuna göre sıralayacagız
														@RequestParam(value = "direction", required = false, // direction required olmasın
														defaultValue = "DESC") Direction direction){
		Pageable pageable=PageRequest.of(page, size, Sort.by(direction,prop));
		
		Page<CarDTO> carDTOPages=carService.getAllCarsWithPage(pageable);
		return ResponseEntity.ok(carDTOPages);
	}
	
	//delete maping
	
	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> deleteById(@PathVariable("id") Long id){
		carService.deleteCarById(id);
		VRResponse response=new VRResponse(ResponseMessage.CAR_DELETED_RESPONSE,true);
		return ResponseEntity.ok(response);
	}
	
	// update car
	@PatchMapping("/update/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> updateCarById(@PathVariable Long id,
													@Valid @RequestBody CarDTO carDTO){
		carService.updateCarById(id,carDTO);
		VRResponse response=new VRResponse(ResponseMessage.CAR_UPDATED_RESPONSE,true);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
	
}
