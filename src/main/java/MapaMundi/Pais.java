package MapaMundi;

import Persona.Rango;
import Pregunta.Pregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pais {
	private String nombre;
	private List<Pregunta> preguntas;

	public Pais(String nombre, List<Pregunta> preguntas){
		this.nombre = nombre;
		if(preguntas == null){
			this.preguntas = new ArrayList<Pregunta>();
		} else {
			this.preguntas = preguntas;
		}
	}

	public List<Pregunta> mostrarPreguntas(Rango rango){
		return preguntas.stream().filter(pregunta->pregunta.esAptaParaMostrar(rango)).collect(Collectors.toList());
	}

	public void agregarPreguntas(List<Pregunta> preguntas){
		preguntas.forEach(pregunta -> agregarPregunta(pregunta));
	}

	public void agregarPregunta(Pregunta pregunta){
		this.preguntas.add(pregunta);
	}

	public List<Pregunta> getPreguntas(){
		return preguntas;
	}
}
