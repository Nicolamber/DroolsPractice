package com.sample;

public class Institucion {
	private String nombreInstitucion;

	public Institucion(String nombre) {
		super();
		this.nombreInstitucion = nombre;
	}

	public String getNombre() {
		return nombreInstitucion;
	}

	public void setNombre(String nombre) {
		this.nombreInstitucion = nombre;
	}
}
