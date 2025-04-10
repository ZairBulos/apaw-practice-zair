package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ArtworkPersistence {
    Stream<Artwork> readAll();
}
