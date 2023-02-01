package com.example.SOCMundi;

import com.example.SOCMundi.MapaMundi.*;
import com.example.SOCMundi.Persona.*;
import com.example.SOCMundi.Pregunta.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGenerales {
	MapaMundi mapamundi = new MapaMundi();
	Usuario usuarioJose = new Usuario();
	Persona jose = new Persona("Jose","Perez", usuarioJose, mapamundi);

	Opcion opcion1 = new Opcion("Carrear, Iniciar tf, afk");
	Opcion opcion2 = new Opcion("Confidencialidad, Integridad y Disponibilidad");
	Opcion opcion3 = new Opcion("Central Intelligence Agency");
	List<Opcion> opciones = new ArrayList<Opcion>();
	Pregunta pregunta1 = new Pregunta("¿Que signific  a CIA?", "Confidencialidad, Integridad y Disponibilidad", 10, new Principiante(), opciones);

	Pais argentina = new Pais("Argentina", null);
	FormularioRespuesta formularioCorrecto = new FormularioRespuesta(jose, pregunta1, opcion2);
	FormularioRespuesta formularioIncorrecto = new FormularioRespuesta(jose, pregunta1, opcion3);
	Grupo grupo = new Grupo(null);

	@BeforeEach
	public void setup(){
		opciones.add(opcion1);
		opciones.add(opcion2);
		opciones.add(opcion3);
	}

	@Test
	public void preguntaQuedaRespondidaCorrectamenteConRespuestaCorrecta(){
		formularioCorrecto.responder();
		assertEquals(formularioCorrecto.preguntaContestada(),true);
	}

	@Test
	public void preguntaNoQuedaRespondidaCorrectamenteConRespuestaCorrecta(){
		formularioIncorrecto.responder();
		assertEquals(formularioCorrecto.preguntaContestada(),false);
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

	@Test
	public void soloSeMuestranLasPreguntasDePrincipiante(){
		Pregunta preguntaTest1 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Principiante(), opciones);
		argentina.setPregunta(preguntaTest1);
		assertEquals(argentina.mostrarPregunta(new Principiante()),preguntaTest1);

		Pregunta preguntaTest2 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Intermedio(), opciones);
		argentina.setPregunta(preguntaTest2);
		assertEquals(argentina.mostrarPregunta(new Intermedio()),preguntaTest2);

		Pregunta preguntaTest3 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Avanzado(), opciones);
		argentina.setPregunta(preguntaTest3);
		assertEquals(argentina.mostrarPregunta(new Avanzado()),preguntaTest3);
	}

	@Test
	public void unGrupoPuedeContenerVariasPersonasPeroNoSeAgreganPersonasQueYaExisten(){
		grupo.agregarPersona(jose);
		grupo.agregarPersona(jose);
		grupo.agregarPersona(jose);
		grupo.agregarPersona(jose);

		assertEquals(grupo.getPersonas().size(),1);

	}
}
