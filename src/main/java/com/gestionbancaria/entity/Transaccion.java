package com.gestionbancaria.entity;

import java.util.Date;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.gestionbancaria.dto.HistorialTransaccionDto;

@DynamoDBTable(tableName = "transaccion")
public class Transaccion {
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String transaccionId;
	@DynamoDBAttribute
	private String cuentaBancariaId;
	@DynamoDBAttribute
	private String tipoTransaccion;
	@DynamoDBAttribute
	private String fechaHora;
	@DynamoDBAttribute
	private HistorialTransaccion detalleTransaccion;

	public Transaccion() {
	}

	public Transaccion(String transaccionId, String cuentaBancariaId, String tipoTransaccion, String fechaHora,
			HistorialTransaccion detalleTransaccion) {
		super();
		this.transaccionId = transaccionId;
		this.cuentaBancariaId = cuentaBancariaId;
		this.tipoTransaccion = tipoTransaccion;
		this.fechaHora = fechaHora;
		this.detalleTransaccion = detalleTransaccion;
	}

	public String getTransaccionId() {
		return transaccionId;
	}

	public void setTransaccionId(String transaccionId) {
		this.transaccionId = transaccionId;
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

	public HistorialTransaccion getDetalleTransaccion() {
		return detalleTransaccion;
	}

	public void setDetalleTransaccion(HistorialTransaccion detalleTransaccion) {
		this.detalleTransaccion = detalleTransaccion;
	}

}
