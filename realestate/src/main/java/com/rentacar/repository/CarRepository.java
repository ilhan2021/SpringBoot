package com.rentacar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentacar.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

	@Query("SELECT count(*) from Car c join c.image img where img.id=:id")
	int countImageById(@Param("id") String id);
	
	
	@EntityGraph(attributePaths = "image")
	List<Car> findAll();
	
	
	@EntityGraph(attributePaths = "image")
	Page<Car> findAll(Pageable pageable);
	
	
	
}
