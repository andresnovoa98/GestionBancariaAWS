package com.gestionbancaria.dto;

import java.util.List;
import java.util.Map;

public class CuentaBancariaDto {
	private String identificacionTitular;
	private String nombreTitular;
	private String saldo;
	private String tipoCuenta;
	private String fechaApertura;
	private Map<String, HistorialTransaccionDto> historialTransaccion;

	public CuentaBancariaDto() {
	}

	public CuentaBancariaDto(String identificacionTitular, String nombreTitular, String saldo, String tipoCuenta,
			String fechaApertura, Map<String, HistorialTransaccionDto> historialTransaccion) {
		this.identificacionTitular = identificacionTitular;
		this.nombreTitular = nombreTitular;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
		this.fechaApertura = fechaApertura;
		this.historialTransaccion = historialTransaccion;
	}

	public String getIdentificacionTitular() {
		return identificacionTitular;
	}

	public void setIdentificacionTitular(String identificacionTitular) {
		this.identificacionTitular = identificacionTitular;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Map<String, HistorialTransaccionDto> getHistorialTransaccion() {
		return historialTransaccion;
	}

	public void setHistorialTransaccion(Map<String, HistorialTransaccionDto> historialTransaccion) {
		this.historialTransaccion = historialTransaccion;
	}

}
