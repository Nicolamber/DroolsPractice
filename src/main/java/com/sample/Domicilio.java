package com.sample;

public class Domicilio {

	private String calle;
	private int numeroDomicilio;
	private Localidad localidad;
	
	public Domicilio(String calle, int numeroDomicilio, Localidad localidad) {
		super();
		this.setCalle(calle);
		this.setNumeroDomicilio(numeroDomicilio);
		this.setLocalidad(localidad);
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumeroDomicilio() {
		return numeroDomicilio;
	}

	public void setNumeroDomicilio(int numeroDomicilio) {
		this.numeroDomicilio = numeroDomicilio;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	
}
