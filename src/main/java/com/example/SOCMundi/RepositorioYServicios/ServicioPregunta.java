package com.example.SOCMundi.RepositorioYServicios;

import com.example.SOCMundi.MapaMundi.Pais;
import com.example.SOCMundi.Pregunta.Pregunta;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioPregunta {
    @Autowired
    private RepoPreguntas repoPreguntas;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Pais crearPregunta(Pregunta pregunta, String nombrePais){
        Pregunta pregunta1 = repoPreguntas.insert(pregunta);
        Pais nuevoPais = new Pais(nombrePais, pregunta);


        Query query = new Query().addCriteria(Criteria.where("nombre").is(nombrePais));
        FindAndReplaceOptions options = new FindAndReplaceOptions().upsert().returnNew();

        return mongoTemplate
                .findAndReplace(query, nuevoPais, options, Pais.class, "Paises", Pais.class);

/*        mongoTemplate.update(Pais.class)
                .matching(Criteria.where("nombre").is(nombrePais))
                .apply(new Update().push("pregunta").value(pregunta1))
                .first();

        return pregunta;
 */
    }

    public Optional<Pregunta> getPreguntaById(ObjectId id){
        return repoPreguntas.findById(id);
    }

    public boolean existePregunta(String pregunta){
        return repoPreguntas.findAll()
                .stream().anyMatch(pregunta1 -> pregunta1.getPregunta().equals(pregunta) );
    }

}
