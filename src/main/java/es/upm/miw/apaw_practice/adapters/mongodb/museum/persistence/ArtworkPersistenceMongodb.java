package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtworkRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtworkEntity;
import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtworkPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("artworkPersistence")
public class ArtworkPersistenceMongodb implements ArtworkPersistence {
    private final ArtworkRepository artworkRepository;

    @Autowired
    public ArtworkPersistenceMongodb(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    @Override
    public Stream<Artwork> readAll() {
        return this.artworkRepository.findAll()
                .stream()
                .map(ArtworkEntity::toArtwork);
    }
}
