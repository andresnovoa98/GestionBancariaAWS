package com.gestionbancaria.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionbancaria.entity.CuentaBancaria;

@EnableScan
@Repository
public interface CuentaBancariaRepository extends CrudRepository<CuentaBancaria, String> {
	//boolean existByNombreTitular(String nombreTitular);
}
