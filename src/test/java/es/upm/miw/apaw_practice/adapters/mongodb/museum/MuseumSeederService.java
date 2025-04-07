package es.upm.miw.apaw_practice.adapters.mongodb.museum;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtworkRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.MuseumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtworkEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ExhibitionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.MuseumEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class MuseumSeederService {

    @Autowired
    private MuseumRepository museumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtworkRepository artworkRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Museum Initial Load -----------");

        ArtworkEntity[] artworks = {
                new ArtworkEntity("Starry Night", "https://img_starry_night", 1001L),
                new ArtworkEntity("Mona Lisa", "https://img_mona_lisa", 1002L),
                new ArtworkEntity("Sunflowers", "https://img_sunflowers", 1003L),
                new ArtworkEntity("The Bedroom", "https://img_the_bedroom", 1004L),
                new ArtworkEntity("Guernica", "https://img_guernica", 1005L),
                new ArtworkEntity("The Scream", "https://img_the_scream", 1006L),
        };
        this.artworkRepository.saveAll(Arrays.asList(artworks));

        ArtistEntity[] artists = {
                new ArtistEntity("Pablo Picasso", "Spanish", "Cubism", List.of(artworks[4])),
                new ArtistEntity("Leonardo da Vinci", "Italian", "Renaissance", List.of(artworks[1])),
                new ArtistEntity("Vincent van Gogh", "Dutch", "Post-Impressionism", List.of(artworks[0], artworks[2], artworks[3])),
                new ArtistEntity("Edvard Munch", "Norwegian", "Expressionism", List.of(artworks[5]))
        };
        this.artistRepository.saveAll(Arrays.asList(artists));

        ExhibitionEntity[] exhibitions = {
                new ExhibitionEntity("Spanish authors", LocalDate.of(2025, 8, 25), BigDecimal.valueOf(20.00)),
                new ExhibitionEntity("Impressionist Wonders", LocalDate.of(2025, 8, 25), BigDecimal.valueOf(35.00)),
                new ExhibitionEntity("The Renaissance Masters", LocalDate.of(2025, 10, 15), BigDecimal.valueOf(15.00)),
                new ExhibitionEntity("Mixed arts", LocalDate.of(2026, 1, 18), BigDecimal.valueOf(69.99))
        };
        this.artistRepository.saveAll(Arrays.asList(artists));

        MuseumEntity[] museums = {
                new MuseumEntity("Van Gogh Museum", "Amsterdam, Netherlands", false, List.of(artists[2]), List.of(exhibitions[1], exhibitions[3])),
                new MuseumEntity("Louvre Museum", "Paris, France", true, List.of(artists[1]), List.of(exhibitions[2])),
                new MuseumEntity("The Prado Museum", "Madrid, Spain", true, List.of(artists[0]), List.of(exhibitions[0])),
        };
        this.museumRepository.saveAll(Arrays.asList(museums));
    }

    public void deleteAll() {
        this.museumRepository.deleteAll();
        this.artistRepository.deleteAll();
        this.artworkRepository.deleteAll();
    }
}
