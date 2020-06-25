package com.sample;

import java.time.LocalDateTime;

public class Recepcion {

	private int numeroRecepcion;
	private boolean fueDespachado;
	private LocalDateTime fechaHora;
	private Paciente paciente;
	private Domicilio domicilio;
	private Motivo motivo;
	private Institucion institucionOrigen;
	private Despacho despacho;
	
	public Recepcion(int numeroRecepcion, boolean fueDespachado, LocalDateTime fechaHora, Paciente paciente,
			Domicilio domicilio, Motivo motivo, Institucion institucionOrigen, Despacho despacho) {
		super();
		this.setNumeroRecepcion(numeroRecepcion);
		this.setFueDespachado(fueDespachado);
		this.setFechaHora(fechaHora);
		this.setPaciente(paciente);
		this.setDomicilio(domicilio);
		this.setMotivo(motivo);
		this.setInstitucionOrigen(institucionOrigen);
		this.setDespacho(despacho);
	}
	
	public Recepcion() {}

	public int getNumeroRecepcion() {
		return numeroRecepcion;
	}

	public void setNumeroRecepcion(int numeroRecepcion) {
		this.numeroRecepcion = numeroRecepcion;
	}

	public boolean isFueDespachado() {
		return fueDespachado;
	}

	public void setFueDespachado(boolean fueDespachado) {
		this.fueDespachado = fueDespachado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Institucion getInstitucionOrigen() {
		return institucionOrigen;
	}

	public void setInstitucionOrigen(Institucion institucionOrigen) {
		this.institucionOrigen = institucionOrigen;
	}

	public Despacho getDespacho() {
		return despacho;
	}

	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}
}
