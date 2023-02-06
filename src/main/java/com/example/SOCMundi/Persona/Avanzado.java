package com.example.SOCMundi.Persona;

public class Avanzado extends RangoPersona {
	public Avanzado(){
		super("Avanzado",999999);
	}

	public RangoPersona proximoRango(){
		return new Avanzado();
	}
}
