package com.cds.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cds.domain.Personel;
import com.cds.personelDTO.PersonelDTO;


public interface PersonelRepository extends JpaRepository<Personel, Long> {

	boolean existsByEmail(String email);
	

	//JPQL ile
	@Query("SELECT p from Personel p where p.job=:mjob")
	List<Personel> findAllEqualsJob(@Param ("mjob") String job);
	
// SQL ile
	@Query(value="select * from Personel p where p.job=:mjob",nativeQuery = true)
	List<Personel> findAllEqualsJob2(@Param ("mjob") String job);

	//JPQL ile
	@Query("select new com.cds.personelDTO.PersonelDTO(p) from Personel p where p.id=:id")
	Optional<PersonelDTO> findPersonelDTOById(@Param ("id") Long id);


	
	
}
