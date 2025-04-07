package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtworkEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ArtworkRepositoryIT {

    @Autowired
    private ArtworkRepository artworkRepository;

    @Test
    void testFindByInventoryNumber() {
        assertTrue(this.artworkRepository.findByInventoryNumber(1004L).isPresent());

        ArtworkEntity artwork = this.artworkRepository.findByInventoryNumber(1004L).get();
        assertEquals("The Bedroom", artwork.getTitle());
        assertEquals("https://img_the_bedroom", artwork.getImage());
    }
}
