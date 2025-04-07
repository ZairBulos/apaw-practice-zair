package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtworkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArtworkRepository extends MongoRepository<ArtworkEntity, String> {
    Optional<ArtworkEntity> findByInventoryNumber(Long inventoryNumber);
}
