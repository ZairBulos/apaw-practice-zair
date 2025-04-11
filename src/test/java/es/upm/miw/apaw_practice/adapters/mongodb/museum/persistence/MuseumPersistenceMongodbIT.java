package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class MuseumPersistenceMongodbIT {

    @Autowired
    private MuseumPersistenceMongodb museumPersistence;

    @Test
    void testReadByNameNotFound() {
        assertThrows(NotFoundException.class, () -> this.museumPersistence.readByName("British Museum"));
    }

    @Test
    void testUpdateExhibitionAdmissionFee() {
        BigDecimal newAdmissionFee = BigDecimal.valueOf(9.99);
        Museum museum = this.museumPersistence.readByName("The Prado Museum");
        museum.getExhibitions().forEach(exhibition -> exhibition.setGeneralAdmissionFee(newAdmissionFee));

        this.museumPersistence.updateExhibitionAdmissionFee(museum);

        Museum updatedMuseum = this.museumPersistence.updateExhibitionAdmissionFee(museum);
        assertEquals(newAdmissionFee, updatedMuseum.getExhibitions().get(0).getGeneralAdmissionFee());
    }
}
