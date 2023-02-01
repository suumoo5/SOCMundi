package com.example.SOCMundi.RepositorioYServicios;

import com.example.SOCMundi.MapaMundi.Pais;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPais {
    @Autowired
    private RepoPais repoPais;

    public List<Pais> getTodosLosPaises(){
        return repoPais.findAll();
    }

    public Optional<Pais> getPais(ObjectId id){
        return repoPais.findById(id);
    }
}
/*

existe el @PostMapping

    MongoTemplate mongoTemplate;
    public void test(ObjectId id, Clase unValor){
        Clase varTemp = repositorio.insert(new Clase(unValor);
        mongoTemplate.update(Pais.class).matching(Criteria.where("id").is(id))
                .apply(new Update().push("variable").value(unValor))
                .first();

    }
*/
