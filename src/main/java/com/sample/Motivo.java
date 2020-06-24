package com.sample;

public class Motivo {

	private String nombreMotivo;
	private Codigo codigoMotivo;
	
	public Motivo(String nombreMotivo, Codigo codigoMotivo) {
		this.setNombreMotivo(nombreMotivo);
		this.setCodigoMotivo(codigoMotivo);
	}

	public String getNombreMotivo() {
		return nombreMotivo;
	}

	public void setNombreMotivo(String nombreMotivo) {
		this.nombreMotivo = nombreMotivo;
	}

	public Codigo getCodigoMotivo() {
		return codigoMotivo;
	}

	public void setCodigoMotivo(Codigo codigoMotivo) {
		this.codigoMotivo = codigoMotivo;
	}
}
