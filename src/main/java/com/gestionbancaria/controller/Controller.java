package com.gestionbancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionbancaria.dto.CuentaBancariaDto;
import com.gestionbancaria.dto.TransaccionDto;
import com.gestionbancaria.entity.CuentaBancaria;
import com.gestionbancaria.entity.Transaccion;
import com.gestionbancaria.service.CuentaBancariaService;
import com.gestionbancaria.service.TransaccionService;

@RestController
public class Controller {

	@Autowired
	CuentaBancariaService cuentaBancariaService;

	@Autowired
	TransaccionService transaccionService;

	@GetMapping("/gestionBancaria")
	public ResponseEntity<List<CuentaBancaria>> list() {
		return ResponseEntity.ok(cuentaBancariaService.lista());
	}

	@GetMapping("/gestionBancaria/{identificacionTitular}")
	public ResponseEntity<CuentaBancaria> readGestionPersonda(
			@PathVariable("identificacionTitular") String identificacionTitular) {
		return ResponseEntity.ok(cuentaBancariaService.cuentaBancaria(identificacionTitular));
	}

	@PostMapping("/gestionBancaria")
	public ResponseEntity<?> createGestionBancaria(@RequestBody CuentaBancariaDto cuentaBancariaDto) {

		return ResponseEntity.ok(cuentaBancariaService.save(cuentaBancariaDto));

	}

	@GetMapping("/transaccionBancaria")
	public ResponseEntity<List<Transaccion>> listaTransaccion() {
		return ResponseEntity.ok(transaccionService.lista());
	}
	
	@GetMapping("/transaccionBancaria/{transaccionId}")
	public ResponseEntity<Transaccion> buscarTransaccion(@PathVariable("transaccionId")String transaccionId){
		return ResponseEntity.ok(transaccionService.transaccion(transaccionId));
	}

	@PostMapping("/transaccionBancaria")
	public ResponseEntity<?> createTransacionBancaria(@RequestBody TransaccionDto transaccionDto) {

		return ResponseEntity.ok(transaccionService.realizarTransaccion(transaccionDto));
	}

}
