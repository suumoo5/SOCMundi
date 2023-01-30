package Pregunta;

import Persona.Rango;

import java.util.List;

public class Pregunta {
	private String pregunta;
	private String respuesta;
	private Integer puntos;
	private Rango rango;
	private List<Opcion> opciones;
	private boolean contestada;

	public Pregunta(String pregunta, String respuesta, Integer puntos, Rango rango, List<Opcion> opciones){
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.puntos = puntos;
		this.rango = rango;
		this.opciones = opciones;
		this.contestada = false;
	}

	public boolean esAptaParaMostrar(Rango rango){
		return this.rango.esMismoRango(rango);
	}

	public boolean esCorrecta(Opcion opcion){
		if(opcion.getOpcion().equals(respuesta)){
			contestada = true;
			return true;
		}
		return false;
	}

	public String getPregunta(){
		return pregunta;
	}
	public String getNombreRango(){
		return rango.getNombre();
	}
	public Integer getPuntos(){
		return puntos;
	}
	public boolean fueContestada(){ return contestada;}
}
