package es.upm.miw.apaw_practice.domain.models.museum;

public class Artwork {
    private String title;
    private String image;
    private Long inventoryNumber;

    public Artwork() {
        // empty for framework
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
    public String toString() {
        return "Artwork{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", inventoryNumber=" + inventoryNumber +
                '}';
    }
}
