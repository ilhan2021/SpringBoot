package com.tpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpe.domain.Kisi;

@Repository
public interface KisiRepository extends JpaRepository<Kisi, Integer> {

}
