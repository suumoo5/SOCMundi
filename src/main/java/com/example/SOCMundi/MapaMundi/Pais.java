package com.example.SOCMundi.MapaMundi;

import com.example.SOCMundi.Persona.*;
import com.example.SOCMundi.Pregunta.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Paises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pais {
	@Id
	private ObjectId id;

	private String nombre;
	private Pregunta pregunta;

	public Pais(String nombre, Pregunta pregunta){
		this.nombre = nombre;
		this.pregunta = pregunta;
	}

	public Pregunta mostrarPregunta(RangoPersona rango){
		if(pregunta.esAptaParaMostrar(rango)){
			return pregunta;
		} else {
			return null;
		}
	}

	public Integer puntosTotales(){
		return pregunta.getPuntos();
	};

	public Pregunta getPregunta(){
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta){
		this.pregunta = pregunta;
	}
	public String getNombre(){return nombre;}
}
