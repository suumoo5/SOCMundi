package Persona;

public class Intermedio extends Rango{
	public Intermedio(){
		super("Intermedio",500);
	}

	public Rango proximoRango(){
		return new Avanzado();
	}
}
