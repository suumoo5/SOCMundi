package com.example.SOCMundi.Pregunta;

import com.example.SOCMundi.Persona.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

public class Pregunta {
	@Id
	private ObjectId id;
	private String imdbId;
	private String pregunta;
	private String respuesta;
	private Integer puntos;
	private Rango rango;
	@DocumentReference
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
