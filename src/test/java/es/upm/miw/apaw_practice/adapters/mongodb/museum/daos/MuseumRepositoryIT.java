package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.MuseumEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
class MuseumRepositoryIT {

    @Autowired
    private MuseumRepository museumRepository;

    @Test
    void findByName() {
        assertTrue(this.museumRepository.findByName("Van Gogh Museum").isPresent());

        MuseumEntity museum = this.museumRepository.findByName("Van Gogh Museum").get();
        assertEquals("Amsterdam, Netherlands", museum.getLocation());
        assertFalse(museum.getOpened());
        assertEquals(1, museum.getArtists().size());
        assertEquals("Vincent van Gogh", museum.getArtists().get(0).getName());
        assertEquals(2, museum.getExhibitions().size());
        assertEquals("Impressionist Wonders", museum.getExhibitions().get(0).getTitle());
        assertEquals("Mixed arts", museum.getExhibitions().get(1).getTitle());
    }
}
