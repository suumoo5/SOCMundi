package com.example.SOCMundi.Pregunta;

import com.example.SOCMundi.Persona.*;

public class FormularioRespuesta {
	private Persona persona;
	private Pregunta pregunta;
	private Opcion opcion;

	public FormularioRespuesta(Persona persona, Pregunta pregunta, Opcion opcion){
		this.persona = persona;
		this.pregunta = pregunta;
		this.opcion = opcion;
	}

	public void responder(){
		if(pregunta.esCorrecta(opcion)){
			persona.sumarPuntos(pregunta.getPuntos());
		}
	}
	public boolean preguntaContestada(){
		return pregunta.fueContestada();
	}
}
