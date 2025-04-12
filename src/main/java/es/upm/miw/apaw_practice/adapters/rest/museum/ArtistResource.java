package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.services.museum.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ArtistResource.ARTISTS)
public class ArtistResource {
    static final String ARTISTS = "/museum/artists";

    private final ArtistService artistService;

    @Autowired
    public ArtistResource(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/search")
    public Stream<Artist> findByTechnique(@RequestParam String q) {
        String technique = new LexicalAnalyzer().extractWithAssure(q, "technique");
        return this.artistService.findByTechnique(technique);
    }

    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return this.artistService.create(artist);
    }
}
