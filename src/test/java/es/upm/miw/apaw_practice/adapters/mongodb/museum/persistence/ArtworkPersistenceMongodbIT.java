package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.MuseumSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ArtworkPersistenceMongodbIT {

    @Autowired
    private ArtworkPersistenceMongodb artworkPersistence;

    @Autowired
    private MuseumSeederService seederService;

    @Test
    void testRead() {
        assertNotNull(this.artworkPersistence.read(1001L));
    }

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.artworkPersistence.read(1000L));
    }

    @Test
    void testUpdate() {
        Optional<Artwork> artwork = Optional.ofNullable(this.artworkPersistence.read(1005L));
        assertTrue(artwork.isPresent());

        artwork.get().setTitle("Guernica");
        artwork.get().setImage("https://img_guernica_picasso");

        this.artworkPersistence.update(artwork.get());

        Optional<Artwork> updatedArtwork = Optional.ofNullable(this.artworkPersistence.read(1005L));
        assertTrue(updatedArtwork.isPresent());
        assertEquals("Guernica", updatedArtwork.get().getTitle());
        assertEquals("https://img_guernica_picasso", updatedArtwork.get().getImage());

        this.seederService.deleteAll();
        this.seederService.seedDatabase();
    }
}
