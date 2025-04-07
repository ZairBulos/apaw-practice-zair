package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ArtistRepositoryIT {

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.artistRepository.findAll().stream()
                .anyMatch(artist ->
                    "Edvard Munch".equals(artist.getName()) &&
                    "Norwegian".equals(artist.getNationality()) &&
                    "Expressionism".equals(artist.getMainTechnique()) &&
                    1 == artist.getArtworks().size() &&
                    "The Scream".equals(artist.getArtworks().get(0).getTitle())
                )
        );
    }
}
