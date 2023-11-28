package com.gestionbancaria.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionbancaria.dto.CuentaBancariaDto;
import com.gestionbancaria.dto.HistorialTransaccionDto;
import com.gestionbancaria.entity.CuentaBancaria;
import com.gestionbancaria.entity.HistorialTransaccion;
import com.gestionbancaria.repository.CuentaBancariaRepository;

@Service
public class CuentaBancariaService {

	@Autowired
	CuentaBancariaRepository cuentaBancariaRepository;

	public List<CuentaBancaria> lista() {
		return (List<CuentaBancaria>) cuentaBancariaRepository.findAll();
	}

	public CuentaBancaria cuentaBancaria(String cuentaBancariaId) {
		return cuentaBancariaRepository.findById(cuentaBancariaId).get();
	}

	public CuentaBancaria save(CuentaBancariaDto dto) {
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		//Map<String, HistorialTransaccionDto> historialTransaccionDto = dto.getHistorialTransaccion();
		Map<String, HistorialTransaccion> historialTransaccion = new HashMap<>();

		/*for (Map.Entry<String, HistorialTransaccionDto> entry : historialTransaccionDto.entrySet()) {
			HistorialTransaccionDto transaccionDto = entry.getValue();
			HistorialTransaccion transaccion = new HistorialTransaccion(transaccionDto.getDescripcion(),
					transaccionDto.getMonto());
			historialTransaccion.put(entry.getKey(), transaccion);
		}*/
		cuentaBancaria.setIdentificacionTitular(dto.getIdentificacionTitular());
		cuentaBancaria.setNombreTitular(dto.getNombreTitular());
		cuentaBancaria.setSaldo(dto.getSaldo());
		cuentaBancaria.setFechaApertura(dto.getFechaApertura());
		cuentaBancaria.setTipoCuenta(dto.getTipoCuenta());
		cuentaBancaria.setHistorialTransaccion(historialTransaccion);

		return cuentaBancariaRepository.save(cuentaBancaria);
	}

	public CuentaBancaria update(CuentaBancariaDto dto) {
		/*
		 * CuentaBancaria cuentaBancaria =
		 * cuentaBancariaRepository.findById(dto.getCuentaBancariaId()).get();
		 * HistorialTransaccion ht = new HistorialTransaccion();
		 * ht.setDescripcion(dto.getHistorialTransaccion().getDescripcion());
		 * ht.setMonto(dto.getHistorialTransaccion().getMonto());
		 * cuentaBancaria.setCuentaBancariaId(dto.getCuentaBancariaId());
		 * cuentaBancaria.setNombreTitular(dto.getNombreTitular());
		 * cuentaBancaria.setSaldo(dto.getSaldo());
		 * cuentaBancaria.setTipoCuenta(dto.getTipoCuenta());
		 * cuentaBancaria.setFechaApertura(dto.getFechaApertura());
		 * cuentaBancaria.setHistorialTransaccion(ht); ;
		 */
		return cuentaBancariaRepository.save(null);
		// return null;
	}

	public void delete(String cuentaBancariaId) {
		cuentaBancariaRepository.deleteById(cuentaBancariaId);
	}

	/*
	 * public boolean existCuentaBancariaId(String cuentaBancariaId) { return
	 * cuentaBancariaRepository.existByCuentaBancariaId(cuentaBancariaId); }
	 */
}
