package com.gestionbancaria.entity;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "cuentaBancaria")
public class CuentaBancaria {
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String cuentaBancariaId;
	@DynamoDBAttribute
	private String identificacionTitular;
	@DynamoDBAttribute
	private String nombreTitular;
	@DynamoDBAttribute
	private String saldo;
	@DynamoDBAttribute
	private String tipoCuenta;
	@DynamoDBAttribute
	private String fechaApertura;
	@DynamoDBAttribute
	private Map<String, HistorialTransaccion> historialTransaccion;

	public CuentaBancaria() {
	}

	public CuentaBancaria(String cuentaBancariaId, String identificacionTitular, String nombreTitular, String saldo,
			String tipoCuenta, String fechaApertura, Map<String, HistorialTransaccion> historialTransaccion) {
		this.cuentaBancariaId = cuentaBancariaId;
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

	public String getCuentaBancariaId() {
		return cuentaBancariaId;
	}

	public void setCuentaBancariaId(String cuentaBancariaId) {
		this.cuentaBancariaId = cuentaBancariaId;
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

	public Map<String, HistorialTransaccion> getHistorialTransaccion() {
		return historialTransaccion;
	}

	public void setHistorialTransaccion(Map<String, HistorialTransaccion> historialTransaccion) {
		this.historialTransaccion = historialTransaccion;
	}

}
