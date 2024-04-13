package com.krakedev.entidades;

public class Cliente {
	private String cedula;
	private String nombre;
	private int numHijos;
	
	
	public Cliente() {
		super();
	}
	
	
	
	public int getNumHijos() {
		return numHijos;
	}



	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}



	public Cliente(String cedula, String nombre,int numeroHijos) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.numHijos=numeroHijos;
	}


	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre +", hijos: "+numHijos+ "]";
	}
	
	
	
}
