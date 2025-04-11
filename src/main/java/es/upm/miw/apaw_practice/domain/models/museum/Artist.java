package es.upm.miw.apaw_practice.domain.models.museum;

import java.util.List;

public class Artist {
    private String name;
    private String nationality;
    private String mainTechnique;
    private List<Artwork> artworks;

    public Artist() {
        // empty for framework
    }

    public Artist(String name, String nationality, String mainTechnique, List<Artwork> artworks) {
        this.name = name;
        this.nationality = nationality;
        this.mainTechnique = mainTechnique;
        this.artworks = artworks;
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

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", mainTechnique='" + mainTechnique + '\'' +
                ", artworks=" + artworks +
                '}';
    }
}
