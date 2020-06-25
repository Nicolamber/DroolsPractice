package com.sample;

public class Paciente {

	private String nombrePaciente;
	private String apellidoPaciente;
	private int edadPaciente;
	private int dniPacient2e;
	//Usamos char para tener F para Femenino y M para Masculino
	private char sexoPaciente;
	private Long telefonoPaciente;
	
	public Paciente(String nombrePaciente, String apellidoPaciente,
			int edadPaciente, int dniPaciente, char sexoPaciente, Long telefonoPaciente) {
		super();
		this.setNombrePaciente(nombrePaciente);
		this.setApellidoPaciente(apellidoPaciente);
		this.setEdadPaciente(edadPaciente);
		this.setDniPacient2e(dniPaciente);
		this.setSexoPaciente(sexoPaciente);
		this.setTelefonoPaciente(telefonoPaciente);
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return apellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}

	public int getEdadPaciente() {
		return edadPaciente;
	}

	public void setEdadPaciente(int edadPaciente) {
		this.edadPaciente = edadPaciente;
	}

	public char getSexoPaciente() {
		return sexoPaciente;
	}

	public void setSexoPaciente(char sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}

	public Long getTelefonoPaciente() {
		return telefonoPaciente;
	}

	public void setTelefonoPaciente(Long telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public int getDniPacient2e() {
		return dniPacient2e;
	}

	public void setDniPacient2e(int dniPacient2e) {
		this.dniPacient2e = dniPacient2e;
	}
}
