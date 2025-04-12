package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;
import es.upm.miw.apaw_practice.domain.services.museum.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(MuseumResource.MUSEUMS)
public class MuseumResource {
    static final String MUSEUMS = "/museum/museums";

    private final MuseumService museumService;

    @Autowired
    public MuseumResource(MuseumService museumService) {
        this.museumService = museumService;
    }

    @GetMapping("/search/{name}")
    public BigDecimal findTotalAdmissionFee(@PathVariable String name) {
        return this.museumService.findTotalAdmissionFee(name);
    }

    @PatchMapping("/{name}/exhibitions")
    public void updateExhibitionAdmissionFee(@PathVariable String name, @RequestBody BigDecimal admissionFee) {
        this.museumService.updateExhibitionAdmissionFee(name, admissionFee);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name) {
        this.museumService.delete(name);
    }
}
