package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

@RestTestConfig
class MuseumResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(MuseumResource.MUSEUMS + "/{name}", "Louvre Museum")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateExhibitionAdmissionFee() {
        this.webTestClient
                .patch()
                .uri(MuseumResource.MUSEUMS + "/{name}/exhibitions", "Van Gogh Museum")
                .body(BodyInserters.fromValue(BigDecimal.ZERO))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Museum.class);
    }
}
