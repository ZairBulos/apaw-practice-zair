package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtworkRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtworkEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtworkPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("artworkPersistence")
public class ArtworkPersistenceMongodb implements ArtworkPersistence {
    private final ArtworkRepository artworkRepository;

    @Autowired
    public ArtworkPersistenceMongodb(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    @Override
    public Stream<Artwork> readAll() {
        return this.artworkRepository.findAll()
                .stream()
                .map(ArtworkEntity::toArtwork);
    }

    @Override
    public Artwork read(Long inventoryNumber) {
        return this.artworkRepository
                .findByInventoryNumber(inventoryNumber)
                .orElseThrow(() -> new NotFoundException("Artwork inventory number: " + inventoryNumber))
                .toArtwork();
    }

    @Override
    public Artwork update(Artwork artwork) {
        ArtworkEntity artworkEntity = this.artworkRepository
                .findByInventoryNumber(artwork.getInventoryNumber())
                .orElseThrow(() -> new NotFoundException("Artwork inventory number: " + artwork.getInventoryNumber()));
        artworkEntity.fromArtwork(artwork);

        return this.artworkRepository.save(artworkEntity).toArtwork();
    }
}
