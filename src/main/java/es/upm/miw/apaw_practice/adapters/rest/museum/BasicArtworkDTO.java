package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artwork;

public record BasicArtworkDTO(String title, Long inventoryNumber) {
    public BasicArtworkDTO(Artwork artwork) {
        this(artwork.getTitle(), artwork.getInventoryNumber());
    }

    @Override
    public String toString() {
        return "BasicArtworkDTO{" +
                "title='" + title + '\'' +
                ", inventoryNumber=" + inventoryNumber +
                '}';
    }
}
