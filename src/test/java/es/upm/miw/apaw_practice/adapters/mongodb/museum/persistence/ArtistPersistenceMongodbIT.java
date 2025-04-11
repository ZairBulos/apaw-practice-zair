package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ArtistPersistenceMongodbIT {

    @Autowired
    private ArtistPersistenceMongodb artistPersistence;

    @Test
    void testCreate() {
        Artist artist = new Artist("Salvador Dalí", "Spanish", "Surrealism", null);

        Artist artistDB = this.artistPersistence.create(artist);

        assertEquals("Salvador Dalí", artistDB.getName());
        assertEquals("Spanish", artistDB.getNationality());
        assertEquals("Surrealism", artistDB.getMainTechnique());
    }

    @Test
    void testArtistExists() {
        assertTrue(this.artistPersistence.existArtist("Pablo Picasso"));
    }

    @Test
    void testArtistNotExists() {
        assertFalse(this.artistPersistence.existArtist("Frida Kahlo"));
    }
}
