package com.example.SOCMundi.Persona;

import com.example.SOCMundi.MapaMundi.Pais;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    List<Persona> personas;
    List<Pais> paisesConquistados;

    public Grupo(List<Persona> personas){
        if (personas == null){
            this.personas = new ArrayList<>();
        } else {
            this.personas = personas;
        }
        paisesConquistados = new ArrayList<>();
    }

    public void agregarPersona(Persona p){
        boolean b = personas.contains(p) ? false : personas.add(p) ;
    }

    public void quitarPersona(Persona p){
        boolean b = personas.contains(p) ? personas.remove(p) : false ;
    }

    public Integer puntosTotales(){
        return (int)paisesConquistados.stream().mapToDouble(pais -> pais.puntosTotales()).sum();
    }

    public List<Persona> getPersonas(){
        return personas;
    }
}
