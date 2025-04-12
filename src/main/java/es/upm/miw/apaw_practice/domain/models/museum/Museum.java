package es.upm.miw.apaw_practice.domain.models.museum;

import java.util.List;

public class Museum {
    private String name;
    private String location;
    private Boolean isOpened;
    private List<Exhibition> exhibitions;
    private List<Artist> artists;
    private MuseumPublisher<Boolean> publisher = new MuseumPublisher<>();

    public Museum() {
        // empty for framework
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
        this.publisher.next(opened);
    }

    public List<Exhibition> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<Exhibition> exhibitions) {
        this.exhibitions = exhibitions;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public MuseumPublisher<Boolean> getPublisher() {
        return publisher;
    }

    public void setPublisher(MuseumPublisher<Boolean> publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", isOpened=" + isOpened +
                ", exhibitions=" + exhibitions +
                ", artists=" + artists +
                '}';
    }
}
