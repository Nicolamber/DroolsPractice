package com.sample;

import java.time.LocalDateTime;

public class Despacho {
	
	private int numeroDespacho;
	private boolean estaRetrasado;
	private LocalDateTime fechaHora;
	private Institucion institucionDestino;
	private Base base;
	
	public Despacho(int numeroDespacho, boolean estaRetrasado, LocalDateTime fechaHora, Institucion institucionDestino,
			Base base) {
		super();
		this.setNumeroDespacho(numeroDespacho);
		this.setEstaRetrasado(estaRetrasado);
		this.setFechaHora(fechaHora);
		this.setInstitucionDestino(institucionDestino);
		this.setBase(base);
	}
	
	public Despacho() {}

	public int getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(int numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	public boolean isEstaRetrasado() {
		return estaRetrasado;
	}

	public void setEstaRetrasado(boolean estaRetrasado) {
		this.estaRetrasado = estaRetrasado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Institucion getInstitucionDestino() {
		return institucionDestino;
	}

	public void setInstitucionDestino(Institucion institucionDestino) {
		this.institucionDestino = institucionDestino;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}
}
