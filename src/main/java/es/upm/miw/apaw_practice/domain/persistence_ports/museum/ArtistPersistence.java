package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistPersistence {
    Artist create(Artist artist);
    boolean existArtist(String name);
}
