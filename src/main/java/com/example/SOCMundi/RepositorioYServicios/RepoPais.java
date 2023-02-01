package com.example.SOCMundi.RepositorioYServicios;

import com.example.SOCMundi.MapaMundi.Pais;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPais extends MongoRepository<Pais, ObjectId> {
}
