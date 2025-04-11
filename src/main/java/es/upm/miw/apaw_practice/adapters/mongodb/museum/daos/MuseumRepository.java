package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.MuseumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MuseumRepository extends MongoRepository<MuseumEntity, String> {
    Optional<MuseumEntity> findByName(String name);
    void deleteByName(String name);
}
