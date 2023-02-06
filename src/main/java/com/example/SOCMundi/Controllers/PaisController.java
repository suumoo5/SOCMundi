package com.example.SOCMundi.Controllers;

import com.example.SOCMundi.MapaMundi.Pais;
import com.example.SOCMundi.RepositorioYServicios.ServicioPais;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    private ServicioPais servicioPais;

    @GetMapping
    public ResponseEntity<List<Pais>> todasLosPaises(){
        return new ResponseEntity<List<Pais>>(servicioPais.getTodosLosPaises(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pais>> getPais(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Pais>>(servicioPais.getPaisById(id), HttpStatus.OK);
    }

    @GetMapping("/pais/{nombre}")
    public ResponseEntity<Optional<Pais>> getPaisByNombre(@PathVariable String nombre){
        return new ResponseEntity<Optional<Pais>>(Optional.ofNullable(servicioPais.getPaisByNombre(nombre)), HttpStatus.OK);
    }
}