package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;
import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class MuseumEntity {

    @Id
    private String id;

    private String name;

    private String location;

    private Boolean isOpened;

    @DBRef
    private List<ArtistEntity> artists;

    private List<ExhibitionEntity> exhibitions;

    public MuseumEntity() {
        // empty for framework
    }

    public MuseumEntity(String name, String location, Boolean isOpened, List<ArtistEntity> artists, List<ExhibitionEntity> exhibitions) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.isOpened = isOpened;
        this.artists = artists;
        this.exhibitions = exhibitions;
    }

    public Museum toMuseum() {
        Museum museum = new Museum();
        BeanUtils.copyProperties(this, museum);
        museum.setExhibitions(this.exhibitions.stream()
                .filter(Objects::nonNull)
                .map(ExhibitionEntity::toExhibition)
                .toList());
        return museum;
    }

    public void fromMuseum(Museum museum) {
        BeanUtils.copyProperties(museum, this);
        this.exhibitions = museum.getExhibitions().stream()
                .filter(Objects::nonNull)
                .map(ExhibitionEntity::new)
                .toList();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getOpened() {
        return isOpened;
    }

    public void setOpened(Boolean opened) {
        isOpened = opened;
    }

    public List<ArtistEntity> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistEntity> artists) {
        this.artists = artists;
    }

    public List<ExhibitionEntity> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<ExhibitionEntity> exhibitions) {
        this.exhibitions = exhibitions;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((MuseumEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "MuseumEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", isOpened=" + isOpened +
                ", artists=" + artists +
                ", exhibitions=" + exhibitions +
                '}';
    }
}
