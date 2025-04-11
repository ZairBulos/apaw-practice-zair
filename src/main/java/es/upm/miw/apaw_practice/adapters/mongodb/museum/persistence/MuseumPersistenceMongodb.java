package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.MuseumRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.MuseumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("museumPersistence")
public class MuseumPersistenceMongodb implements MuseumPersistence {
    private final MuseumRepository museumRepository;

    @Autowired
    public MuseumPersistenceMongodb(MuseumRepository museumRepository) {
        this.museumRepository = museumRepository;
    }

    @Override
    public void delete(String name) {
        this.museumRepository.deleteByName(name);
    }
}
