package com.gestionbancaria.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionbancaria.dto.HistorialTransaccionDto;
import com.gestionbancaria.dto.TransaccionDto;
import com.gestionbancaria.entity.CuentaBancaria;
import com.gestionbancaria.entity.DetalleTransaccion;
import com.gestionbancaria.entity.HistorialTransaccion;
import com.gestionbancaria.entity.Transaccion;
import com.gestionbancaria.repository.CuentaBancariaRepository;
import com.gestionbancaria.repository.TransaccionRepository;

@Service
public class TransaccionService {

	@Autowired
	TransaccionRepository transaccionRepository;

	@Autowired
	CuentaBancariaRepository cuentaBancariaRepository;

	public List<Transaccion> lista() {
		return (List<Transaccion>) transaccionRepository.findAll();
	}
	
	public Transaccion transaccion(String transaccionId) {
		return transaccionRepository.findById(transaccionId).get();
	}

	public Transaccion realizarTransaccion(TransaccionDto transaccionDto) {
		Random random = new Random();
		int seriaTransaccion = random.nextInt(100000);
		Date date = new Date();
		Transaccion transaccion = new Transaccion();

		CuentaBancaria cuentaBancaria = cuentaBancariaRepository.findById(transaccionDto.getCuentaBancariaId()).get();

		HistorialTransaccion historialTransaccionG = new HistorialTransaccion();
		HistorialTransaccionDto htD = new HistorialTransaccionDto();

		if (transaccionDto.getTipoTransaccion().equalsIgnoreCase("Deposito")) {
			int saldo = Integer.parseInt(cuentaBancaria.getSaldo())
					+ Integer.parseInt(transaccionDto.getDetalleTransaccion().getMonto());
			cuentaBancaria.setSaldo(String.valueOf(saldo));

			historialTransaccionG.setDescripcion("Se realizo el deposito correctamente.");
			historialTransaccionG.setMonto(transaccionDto.getDetalleTransaccion().getMonto());

			htD.setMonto(transaccionDto.getDetalleTransaccion().getMonto());
			htD.setDescripcion("Se realizo el deposito correctamente.");
		} else {
			if (Integer.parseInt(cuentaBancaria.getSaldo()) >= 0 && Integer.parseInt(cuentaBancaria.getSaldo())
					- Integer.parseInt(transaccionDto.getDetalleTransaccion().getMonto()) >= 0) {
				int saldo = Integer.parseInt(cuentaBancaria.getSaldo())
						- Integer.parseInt(transaccionDto.getDetalleTransaccion().getMonto());
				cuentaBancaria.setSaldo(String.valueOf(saldo));

				historialTransaccionG.setDescripcion("Se realizo el retiro correctamente.");
				historialTransaccionG.setMonto(transaccionDto.getDetalleTransaccion().getMonto());

				htD.setMonto(transaccionDto.getDetalleTransaccion().getMonto());
				htD.setDescripcion("Se realizo el retiro correctamente.");
			} else {
				historialTransaccionG.setDescripcion("Saldo insuficiente.");
				historialTransaccionG.setMonto(transaccionDto.getDetalleTransaccion().getMonto());

				htD.setMonto(transaccionDto.getDetalleTransaccion().getMonto());
				htD.setDescripcion("Saldo insuficiente.");
			}
		}

		Map<String, HistorialTransaccionDto> historialTransaccionDto = new HashMap<>();
		historialTransaccionDto.put("transancion_" + seriaTransaccion, htD);
		Map<String, HistorialTransaccion> historialTransaccion = cuentaBancaria.getHistorialTransaccion();

		for (Map.Entry<String, HistorialTransaccionDto> entry : historialTransaccionDto.entrySet()) {
			HistorialTransaccionDto transaccionDtoM = entry.getValue();
			HistorialTransaccion transaccionM = new HistorialTransaccion(transaccionDtoM.getDescripcion(),
					transaccionDtoM.getMonto());
			historialTransaccion.put(entry.getKey(), transaccionM);
		}

		cuentaBancaria.setHistorialTransaccion(historialTransaccion);
		cuentaBancariaRepository.save(cuentaBancaria);

		transaccion.setCuentaBancariaId(transaccionDto.getCuentaBancariaId());
		transaccion.setFechaHora(date.toString());
		transaccion.setTipoTransaccion(transaccionDto.getTipoTransaccion());
		transaccion.setDetalleTransaccion(historialTransaccionG);

		return transaccionRepository.save(transaccion);
	}

}
