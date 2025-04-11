package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.persistence_ports.museum.MuseumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuseumService {
    private final MuseumPersistence museumPersistence;

    @Autowired
    public MuseumService(MuseumPersistence museumPersistence) {
        this.museumPersistence = museumPersistence;
    }

    public void delete(String name) {
        this.museumPersistence.delete(name);
    }
}
