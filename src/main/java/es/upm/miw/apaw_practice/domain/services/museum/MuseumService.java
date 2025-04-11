package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.MuseumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MuseumService {
    private final MuseumPersistence museumPersistence;

    @Autowired
    public MuseumService(MuseumPersistence museumPersistence) {
        this.museumPersistence = museumPersistence;
    }

    public Museum readByName(String name) {
        return this.museumPersistence.readByName(name);
    }

    public void delete(String name) {
        this.museumPersistence.delete(name);
    }

    public void updateExhibitionAdmissionFee(String name, BigDecimal admissionFee) {
        Museum museum = this.museumPersistence.readByName(name);
        museum.getExhibitions()
                .forEach(exhibition -> exhibition.setGeneralAdmissionFee(admissionFee));

        this.museumPersistence.updateExhibitionAdmissionFee(museum);
    }
}
