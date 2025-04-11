package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class ArtistEntity {

    @Id
    private String id;

    private String name;

    private String nationality;

    private String mainTechnique;

    @DBRef
    private List<ArtworkEntity> artworks;

    public ArtistEntity() {
        // empty for framework
    }

    public ArtistEntity(Artist artist) {
        BeanUtils.copyProperties(artist, this);
        this.id = UUID.randomUUID().toString();
    }

    public ArtistEntity(String name, String nationality, String mainTechnique, List<ArtworkEntity> artworks) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.nationality = nationality;
        this.mainTechnique = mainTechnique;
        this.artworks = artworks;
    }

    public Artist toArtist() {
        Artist artist = new Artist();
        BeanUtils.copyProperties(this, artist);
        return artist;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMainTechnique() {
        return mainTechnique;
    }

    public void setMainTechnique(String mainTechnique) {
        this.mainTechnique = mainTechnique;
    }

    public List<ArtworkEntity> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<ArtworkEntity> artworks) {
        this.artworks = artworks;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((ArtistEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", mainTechnique='" + mainTechnique + '\'' +
                ", artworks=" + artworks +
                '}';
    }
}
