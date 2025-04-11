package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.Artwork;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class ArtworkEntity {

    @Id
    private String id;

    private String title;

    private String image;

    @Indexed(unique = true)
    private Long inventoryNumber;

    public ArtworkEntity() {
        // empty for framework
    }

    public ArtworkEntity(String title, String image, Long inventoryNumber) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.image = image;
        this.inventoryNumber = inventoryNumber;
    }

    public Artwork toArtwork() {
        Artwork artwork = new Artwork();
        BeanUtils.copyProperties(this, artwork);
        return artwork;
    }

    public void fromArtwork(Artwork artwork) {
        BeanUtils.copyProperties(artwork, this);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Long inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (inventoryNumber.equals(((ArtworkEntity) obj).inventoryNumber));
    }

    @Override
    public int hashCode() {
        return this.inventoryNumber.hashCode();
    }

    @Override
    public String toString() {
        return "ArtworkEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", inventoryNumber=" + inventoryNumber +
                '}';
    }
}

