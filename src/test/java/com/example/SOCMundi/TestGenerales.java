package com.example.SOCMundi;

import com.example.SOCMundi.MapaMundi.*;
import com.example.SOCMundi.Persona.*;
import com.example.SOCMundi.Pregunta.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGenerales {
	MapaMundi mapamundi = new MapaMundi();
	Usuario usuarioJose = new Usuario();
	Persona jose = new Persona("Jose","Perez", usuarioJose, mapamundi);

	Pregunta pregunta1 = new Pregunta("¿Que signific  a CIA?", "Confidencialidad, Integridad y Disponibilidad", 10, "Principiante");

	Pais argentina = new Pais("Argentina", pregunta);
	FormularioRespuesta formularioCorrecto = new FormularioRespuesta(jose, pregunta1, "Confidencialidad, Integridad y Disponibilidad");
	FormularioRespuesta formularioIncorrecto = new FormularioRespuesta(jose, pregunta1, "Cosa invertebrada digestible");
	Grupo grupo = new Grupo(null);

	@BeforeEach
	public void setup(){

	}

	@Test
	public void preguntaQuedaRespondidaCorrectamenteConRespuestaCorrecta(){
		formularioCorrecto.responder();
		assertEquals(jose.getPuntuacion(),10);
		assertEquals(pregunta1.fueContestada(),true);
	}

	@Test
	public void preguntaNoQuedaRespondidaCorrectamenteConRespuestaCorrecta(){
		formularioIncorrecto.responder();
		assertEquals(jose.getPuntuacion(),0);
		assertEquals(pregunta1.fueContestada(),false);
	}

	@Test
	public void noSeAvanzaDeRangoSiNoseSuperaElMaximo(){
		jose.sumarPuntos(50);
		assertEquals(jose.nombreDelRango(), "Principiante");
	}

	@Test
	public void sePuedePasarDePrincipianteAIntermedio(){
		jose.setRango(new Principiante());
		jose.sumarPuntos(200);
		assertEquals(jose.nombreDelRango(), "Intermedio");
	}

	@Test
	public void sePuedePasarDeIntermedioAAvanzado(){
		jose.setRango(new Intermedio());
		jose.sumarPuntos(501);
		assertEquals(jose.nombreDelRango(), "Avanzado");
	}

	@Test
	public void noSePuedePasarMasAllaDeAvanzado(){
		jose.setRango(new Intermedio());
		jose.sumarPuntos(9999999);
		assertEquals(jose.nombreDelRango(), "Avanzado");
	}

/*	@Test
	public void soloSeMuestranLasPreguntasDePrincipiante(){
		Pregunta preguntaTest1 = new Pregunta("TestPregunta", "TestRespuesta", 10, "Principiante");
		argentina.agregarPregunta(preguntaTest1);
		assertEquals(argentina.mostrarPregunta(new Principiante()),preguntaTest1);

		Pregunta preguntaTest2 = new Pregunta("TestPregunta", "TestRespuesta", 10, "Intermedio");
		argentina.agregarPregunta(preguntaTest2);
		assertEquals(argentina.mostrarPregunta(new Intermedio()),preguntaTest2);

		Pregunta preguntaTest3 = new Pregunta("TestPregunta", "TestRespuesta", 10, "Avanzado");
		argentina.agregarPregunta(preguntaTest3);
		assertEquals(argentina.mostrarPregunta(new Avanzado()),preguntaTest3);
	}
*/
	@Test
	public void unGrupoPuedeContenerVariasPersonasPeroNoSeAgreganPersonasQueYaExisten(){
		grupo.agregarPersona(jose);
		grupo.agregarPersona(jose);
		grupo.agregarPersona(jose);
		grupo.agregarPersona(jose);

		assertEquals(grupo.getPersonas().size(),1);

	}

}
