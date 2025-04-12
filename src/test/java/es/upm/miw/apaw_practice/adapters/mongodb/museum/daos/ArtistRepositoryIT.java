package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void testFindByMainTechnique() {
        String technique = "Post-Impressionism";
        Stream<ArtistEntity> artists = this.artistRepository.findByMainTechniqueIgnoreCase(technique.toLowerCase());

        artists.forEach(artist ->  assertEquals(technique, artist.getMainTechnique()));
    }
}
