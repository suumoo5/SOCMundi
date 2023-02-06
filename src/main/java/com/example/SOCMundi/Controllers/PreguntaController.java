package com.example.SOCMundi.Controllers;

import com.example.SOCMundi.MapaMundi.Pais;
import com.example.SOCMundi.Pregunta.*;
import com.example.SOCMundi.RepositorioYServicios.ServicioPais;
import com.example.SOCMundi.RepositorioYServicios.ServicioPregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/no-connect/preguntas")
public class PreguntaController {
    @Autowired
    private ServicioPregunta servicioPregunta;

    @Autowired
    private ServicioPais servicioPais;

    @GetMapping
    public ResponseEntity<String> get(){
        return new ResponseEntity<String>("Get preguntas Ok",HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pais> agregarPregunta(@RequestBody Map<String,String> payload){
        Pregunta pregunta = new Pregunta(payload.get("pregunta"),payload.get("respuesta"), Integer.valueOf(payload.get("puntos")), payload.get("rango"));
        String nombrePais = payload.get("nombrePais");


        if(!servicioPregunta.existePregunta(pregunta.getPregunta())){
            return new ResponseEntity<Pais>(servicioPregunta
                    .crearPregunta(pregunta, nombrePais), HttpStatus.CREATED);
        } else {
            return null;
        }


    }
}
