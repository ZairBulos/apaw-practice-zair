package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class MuseumServiceIT {

    @Autowired
    private MuseumService museumService;

    @Test
    void testUpdateExhibitionAdmissionFee() {
        BigDecimal newAdmissionFee = BigDecimal.valueOf(9.99);

        this.museumService.updateExhibitionAdmissionFee("Van Gogh Museum", newAdmissionFee);
        Museum updatedMuseum = this.museumService.readByName("Van Gogh Museum");

        updatedMuseum.getExhibitions().forEach(exhibition ->
            assertEquals(newAdmissionFee, exhibition.getGeneralAdmissionFee())
        );
    }
}
