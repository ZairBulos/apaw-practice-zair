package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class ArtworkResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(ArtworkResource.ARTWORKS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BasicArtworkDTO.class)
                .value(artworks -> assertEquals(6, artworks.size()));
    }

    @Test
    void testUpdate() {
        Artwork artwork = new Artwork(1004L, "The Bedroom", "https://img_the_bedroom_van_gogh");

        this.webTestClient
                .put()
                .uri(ArtworkResource.ARTWORKS + "/{inventoryNumber}", 1004L)
                .body(BodyInserters.fromValue(artwork))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Artwork.class)
                .value(artworkData -> {
                    assertEquals("The Bedroom", artworkData.getTitle());
                    assertEquals("https://img_the_bedroom_van_gogh", artworkData.getImage());
                });
    }

    @Test
    void testUpdateNotFound() {
        Artwork artwork = new Artwork(1000L, "Las dos Fridas", "https://img_las_dos_fridas");

        this.webTestClient
                .put()
                .uri(ArtworkResource.ARTWORKS + "/{inventoryNumber}", 1000L)
                .body(BodyInserters.fromValue(artwork))
                .exchange()
                .expectStatus().isNotFound();
    }
}
