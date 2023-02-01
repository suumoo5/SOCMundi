package com.example.SOCMundi.Persona;

public class Avanzado extends Rango {
	public Avanzado(){
		super("Avanzado",999999);
	}

	public Rango proximoRango(){
		return new Avanzado();
	}
}
