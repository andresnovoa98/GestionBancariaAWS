package com.gestionbancaria.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionbancaria.entity.Transaccion;

@EnableScan
@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, String> {
	//List<Transaccion> findByIdCuentaBancaria(String idCuentaBancaria);
}
