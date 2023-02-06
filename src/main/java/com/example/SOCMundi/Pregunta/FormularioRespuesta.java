package com.example.SOCMundi.Pregunta;

import com.example.SOCMundi.Persona.*;

public class FormularioRespuesta {
	private Persona persona;
	private Pregunta pregunta;
	private String opcion;

	public FormularioRespuesta(Persona persona, Pregunta pregunta, String opcion){
		this.persona = persona;
		this.pregunta = pregunta;
		this.opcion = opcion;
	}

	public void responder(){
		if(!pregunta.fueContestada() && pregunta.opcionEsCorrecta(opcion)){
			pregunta.responder();
			persona.sumarPuntos(pregunta.getPuntos());
		}
	}
}
