package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface ArtistRepository extends MongoRepository<ArtistEntity, String> {
    Optional<ArtistEntity> findByName(String name);
    Stream<ArtistEntity> findByMainTechniqueIgnoreCase(String technique);
}
