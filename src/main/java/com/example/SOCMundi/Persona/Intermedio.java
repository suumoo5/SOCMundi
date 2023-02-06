package com.example.SOCMundi.Persona;

public class Intermedio extends RangoPersona {
	public Intermedio(){
		super("Intermedio",500);
	}

	public RangoPersona proximoRango(){
		return new Avanzado();
	}
}
