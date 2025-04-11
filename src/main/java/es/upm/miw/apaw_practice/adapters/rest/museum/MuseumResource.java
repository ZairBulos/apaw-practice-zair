package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.services.museum.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MuseumResource.MUSEUMS)
public class MuseumResource {
    static final String MUSEUMS = "/museum/museums";

    private final MuseumService museumService;

    @Autowired
    public MuseumResource(MuseumService museumService) {
        this.museumService = museumService;
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name) {
        this.museumService.delete(name);
    }
}
