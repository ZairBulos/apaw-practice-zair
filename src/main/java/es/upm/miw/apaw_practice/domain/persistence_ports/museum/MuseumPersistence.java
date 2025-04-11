package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumPersistence {
    Museum readByName(String name);
    Museum updateExhibitionAdmissionFee(Museum museum);
    void delete(String name);
}
