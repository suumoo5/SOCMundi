import Persona.*;
import MapaMundi.*;
import Pregunta.*;

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
	public void sePuedeAgregarUnaPreguntaAUnPais(){
		Pregunta preguntaTest1 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Intermedio(), opciones);

		argentina.agregarPregunta(preguntaTest1);
		argentina.agregarPregunta(preguntaTest1);
		argentina.agregarPregunta(preguntaTest1);

		System.out.println(argentina.getPreguntas().get(0).getPregunta());
		assertEquals(argentina.getPreguntas().size(), 3);
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
		Pregunta preguntaTest2 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Intermedio(), opciones);
		Pregunta preguntaTest3 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Avanzado(), opciones);
		Pregunta preguntaTest4 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Intermedio(), opciones);
		Pregunta preguntaTest5 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Avanzado(), opciones);
		Pregunta preguntaTest6 = new Pregunta("TestPregunta", "TestRespuesta", 10, new Avanzado(), opciones);

		argentina.agregarPregunta(preguntaTest1);argentina.agregarPregunta(preguntaTest2);argentina.agregarPregunta(preguntaTest3);argentina.agregarPregunta(preguntaTest4);
		argentina.agregarPregunta(preguntaTest5);argentina.agregarPregunta(preguntaTest6);

		assertEquals(argentina.mostrarPreguntas(new Principiante()).size(),1);
		assertEquals(argentina.mostrarPreguntas(new Intermedio()).size(),2);
		assertEquals(argentina.mostrarPreguntas(new Avanzado()).size(),3);
	}
}
