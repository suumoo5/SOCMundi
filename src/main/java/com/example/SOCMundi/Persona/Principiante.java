package com.example.SOCMundi.Persona;

public class Principiante extends RangoPersona {
	public Principiante(){
		super("Principiante",100);
	}

	public RangoPersona proximoRango(){
		return new Intermedio();
	}
}
