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

    @Test
    void testUpdate() {
        Artwork artwork = new Artwork(1004L, "The Bedroom", "https://img_the_bedroom_van_gogh");

        Artwork updatedArtwork = this.artworkService.update(1004L, artwork);
        assertEquals("The Bedroom", updatedArtwork.getTitle());
        assertEquals("https://img_the_bedroom_van_gogh", updatedArtwork.getImage());

        // Restore the original state of the artwork in the database
        this.artworkService.update(1004L, new Artwork(1004L, "The Bedroom", "https://img_the_bedroom"));
    }
}
