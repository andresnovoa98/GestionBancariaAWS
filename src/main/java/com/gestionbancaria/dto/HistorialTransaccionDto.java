package com.gestionbancaria.dto;

public class HistorialTransaccionDto {

	private String descripcion;
	private String monto;

	public HistorialTransaccionDto() {
	}

	public HistorialTransaccionDto(String descripcion, String monto) {
		this.descripcion = descripcion;
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

}
