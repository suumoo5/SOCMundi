package com.example.SOCMundi.RepositorioYServicios;

import com.example.SOCMundi.MapaMundi.Pais;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioPais {
    @Autowired
    private RepoPais repoPais;

    public List<Pais> getTodosLosPaises(){
        return repoPais.findAll();
    }

    public Optional<Pais> getPaisById(ObjectId id){
        return repoPais.findById(id);
    }

    public Pais getPaisByNombre(String nombre){
        List<Pais> paises = repoPais.findAll();

        return paises.stream()
                .filter(pais -> pais.getNombre().equals(nombre))
                .collect(Collectors.toList())
                .get(0);
    }

    public void setRepo(RepoPais rp){this.repoPais = rp;}
}

