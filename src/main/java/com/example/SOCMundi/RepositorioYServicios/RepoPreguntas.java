package com.example.SOCMundi.RepositorioYServicios;

import com.example.SOCMundi.Pregunta.Pregunta;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPreguntas extends MongoRepository<Pregunta, ObjectId> {

}
