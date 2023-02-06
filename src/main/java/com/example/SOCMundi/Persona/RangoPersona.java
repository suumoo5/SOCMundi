package com.example.SOCMundi.Persona;

public abstract class RangoPersona {
	private String nombre;
	private Integer maximo;

	public RangoPersona(String nombre, Integer maximo){
		this.nombre = nombre;
		this.maximo = maximo;
	}

	public abstract RangoPersona proximoRango();
	public boolean esMismoRango(RangoPersona rango){
		return nombre.equals(rango.getNombre());
	}
	public String getNombre(){
		return nombre;
	}
	public Integer getMaximo(){
		return maximo;
	}
}

