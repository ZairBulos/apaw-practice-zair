package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ArtistPersistence {
    Stream<Artist> findByTechnique(String technique);
    Artist create(Artist artist);
    boolean existArtist(String name);
}
