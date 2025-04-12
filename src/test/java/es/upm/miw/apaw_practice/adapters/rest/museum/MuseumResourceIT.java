package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testSearch() {
        this.webTestClient
                .get()
                .uri(MuseumResource.MUSEUMS + "/search/{name}", "The Prado Museum")
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigInteger.class)
                .value(resultData -> assertEquals(BigDecimal.valueOf(20.00), new BigDecimal(resultData).setScale(1)));
    }
}
