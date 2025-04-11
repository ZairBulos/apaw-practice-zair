package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.MuseumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.MuseumEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Museum;
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
    public Museum readByName(String name) {
        return this.museumRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Museum: " + name))
                .toMuseum();
    }

    @Override
    public Museum updateExhibitionAdmissionFee(Museum museum) {
        MuseumEntity museumEntity = this.museumRepository.findByName(museum.getName())
                .orElseThrow(() -> new NotFoundException("Museum: " + museum.getName()));
        museumEntity.fromMuseum(museum);

        return this.museumRepository
                .save(museumEntity)
                .toMuseum();
    }

    @Override
    public void delete(String name) {
        this.museumRepository.deleteByName(name);
    }
}
