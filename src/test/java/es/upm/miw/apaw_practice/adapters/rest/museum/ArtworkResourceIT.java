package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

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
}
