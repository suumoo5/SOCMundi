package Persona;

import MapaMundi.MapaMundi;

public class Persona {
	private String nombre;
	private String apellido;
	private int puntuacion;
	private Usuario usuario;
	private MapaMundi mapamundi;
	private Rango rango;

	public Persona(String nombre, String apellido, Usuario usuario, MapaMundi mapamundi){
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.puntuacion = 0;
		this.mapamundi = mapamundi;
		this.rango = new Principiante();
	}

	public void sumarPuntos(Integer puntos){
		puntuacion = puntuacion + puntos;
		if(aptoDeRecategorizar()){
			this.rango = rango.proximoRango();
		}
	}

	private boolean aptoDeRecategorizar(){
		return puntuacion > rango.getMaximo();
	}
	public String nombreDelRango(){
		return rango.getNombre();
	}

	public void setRango(Rango rango){
		this.rango = rango;
	}
}
