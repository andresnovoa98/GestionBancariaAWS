package com.gestionbancaria.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class HistorialTransaccion {
	@DynamoDBAttribute
	private String descripcion;
	@DynamoDBAttribute
	private String monto;

	public HistorialTransaccion() {
	}

	public HistorialTransaccion(String descripcion, String monto) {
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
