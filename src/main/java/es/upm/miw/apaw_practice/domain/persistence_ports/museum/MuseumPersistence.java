package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import org.springframework.stereotype.Repository;

@Repository
public interface MuseumPersistence {
    void delete(String name);
}
