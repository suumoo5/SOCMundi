package Persona;

public abstract class Rango {
	private String nombre;
	private Integer maximo;
	private Rango proximoRango;

	public Rango(String nombre, Integer maximo){
		this.nombre = nombre;
		this.maximo = maximo;
	}

	public abstract Rango proximoRango();
	public boolean esMismoRango(Rango rango){
		return nombre.equals(rango.getNombre());
	}
	public String getNombre(){
		return nombre;
	}
	public Integer getMaximo(){
		return maximo;
	}
}

