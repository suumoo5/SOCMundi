package com.example.SOCMundi.Persona;

import com.example.SOCMundi.MapaMundi.*;

public class Persona {
	private String nombre;
	private String apellido;
	private int puntuacion;
	private Usuario usuario;
	private MapaMundi mapamundi;
	private RangoPersona rango;

	public Persona(String nombre, String apellido, Usuario usuario, MapaMundi mapamundi){
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.puntuacion = 0;
		this.mapamundi = mapamundi;
		this.rango = new Principiante();
	}

	public void sumarPuntos(Integer puntos){
		puntuacion = puntuacion + puntos;
		if(aptoDeRecategorizar()){
			this.rango = rango.proximoRango();
		}
	}

	private boolean aptoDeRecategorizar(){
		return puntuacion > rango.getMaximo();
	}
	public String nombreDelRango(){
		return rango.getNombre();
	}
	public void setRango(RangoPersona rango){
		this.rango = rango;
	}
	public Integer getPuntuacion(){
		return puntuacion;
	}
}
