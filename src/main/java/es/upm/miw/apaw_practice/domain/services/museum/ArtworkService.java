package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtworkPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ArtworkService {
    private final ArtworkPersistence artworkPersistence;

    @Autowired
    public ArtworkService(ArtworkPersistence artworkPersistence) {
        this.artworkPersistence = artworkPersistence;
    }

    public Stream<Artwork> readAll() {
        return this.artworkPersistence.readAll();
    }
}
