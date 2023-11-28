package com.gestionbancaria.dto;

import java.util.Map;

import com.gestionbancaria.entity.HistorialTransaccion;

public class TransaccionDto {
	private String cuentaBancariaId;
	private String tipoTransaccion;
	private String fechaHora;
	private HistorialTransaccionDto detalleTransaccion;

	public TransaccionDto() {
	}

	public TransaccionDto(String cuentaBancariaId, String tipoTransaccion, String fechaHora,
			HistorialTransaccionDto detalleTransaccion) {
		super();
		this.cuentaBancariaId = cuentaBancariaId;
		this.tipoTransaccion = tipoTransaccion;
		this.fechaHora = fechaHora;
		this.detalleTransaccion = detalleTransaccion;
	}

	public String getCuentaBancariaId() {
		return cuentaBancariaId;
	}

	public void setCuentaBancariaId(String cuentaBancariaId) {
		this.cuentaBancariaId = cuentaBancariaId;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public HistorialTransaccionDto getDetalleTransaccion() {
		return detalleTransaccion;
	}

	public void setDetalleTransaccion(HistorialTransaccionDto detalleTransaccion) {
		this.detalleTransaccion = detalleTransaccion;
	}

}
