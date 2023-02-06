package com.example.SOCMundi.Pregunta;

import com.example.SOCMundi.Persona.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pregunta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
	@Id
	private ObjectId id;
	private String preguntaStr;
	private String respuesta;
	private Integer puntos;
	private String rango;
	private boolean contestada;

	public Pregunta(String pregunta, String respuesta, Integer puntos, String rango){
		this.preguntaStr = pregunta;
		this.respuesta = respuesta;
		this.puntos = puntos;
		this.rango = rango;
		this.contestada = false;
	}

	public boolean esAptaParaMostrar(RangoPersona rango){
		return this.rango.equals(rango.getNombre());
	}

	public boolean opcionEsCorrecta(String opcion){
		return opcion.equals(respuesta);
	}

	public void responder(){
		this.contestada = true;
	}

	public ObjectId getId(){
		return id;
	}
	public String getPregunta(){
		return preguntaStr;
	}
	public String getNombreRango(){
		return rango;
	}
	public Integer getPuntos(){
		return puntos;
	}
	public boolean fueContestada(){ return contestada;}
}
