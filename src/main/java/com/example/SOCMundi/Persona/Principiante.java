package com.example.SOCMundi.Persona;

public class Principiante extends Rango{
	public Principiante(){
		super("Principiante",100);
	}

	public Rango proximoRango(){
		return new Intermedio();
	}
}
