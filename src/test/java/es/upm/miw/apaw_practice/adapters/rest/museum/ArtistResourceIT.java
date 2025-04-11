package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class ArtistResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Artist artist = new Artist("Claude Monet", "French", "Impressionism", null);

        this.webTestClient
                .post()
                .uri(ArtistResource.ARTISTS)
                .body(BodyInserters.fromValue(artist))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Artist.class);
    }

    @Test
    void testCreateConflict() {
        Artist artist = new Artist("Leonardo da Vinci", "Italian", "Renaissance", null);

        this.webTestClient
                .post()
                .uri(ArtistResource.ARTISTS)
                .body(BodyInserters.fromValue(artist))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
