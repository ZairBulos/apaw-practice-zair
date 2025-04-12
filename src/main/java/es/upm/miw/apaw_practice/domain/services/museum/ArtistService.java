package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ArtistService {
    private final ArtistPersistence artistPersistence;

    @Autowired
    public ArtistService(ArtistPersistence artistPersistence) {
        this.artistPersistence = artistPersistence;
    }

    public Artist create(Artist artist) {
        this.assertArtistNotExist(artist.getName());
        return this.artistPersistence.create(artist);
    }

    public void assertArtistNotExist(String artistName) {
        if (this.artistPersistence.existArtist(artistName)) {
            throw new ConflictException("Artist exist: " + artistName);
        }
    }

    public Stream<Artist> findByTechnique(String technique) {
        return this.artistPersistence.findByTechnique(technique);
    }
}
