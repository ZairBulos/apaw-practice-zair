package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import es.upm.miw.apaw_practice.domain.services.museum.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(ArtworkResource.ARTWORKS)
public class ArtworkResource {
    static final String ARTWORKS = "/museum/artworks";

    private final ArtworkService artworkService;

    @Autowired
    public ArtworkResource(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping
    public Stream<BasicArtworkDTO> readAll() {
        return this.artworkService.readAll()
                .map(BasicArtworkDTO::new);
    }
}
