package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ArtworkServiceIT {

    @Autowired
    private ArtworkService artworkService;

    @Test
    void testReadAll() {
        List<Artwork> artworks = this.artworkService.readAll().toList();

        assertEquals(6, artworks.size());
    }
}
