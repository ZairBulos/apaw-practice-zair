package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExhibitionEntity {
    private String title;
    private LocalDate startDate;
    private BigDecimal generalAdmissionFee;

    public ExhibitionEntity() {
        // empty for framework
    }

    public ExhibitionEntity(Exhibition exhibition) {
        BeanUtils.copyProperties(exhibition, this);
    }

    public ExhibitionEntity(String title, LocalDate startDate, BigDecimal generalAdmissionFee) {
        this.title = title;
        this.startDate = startDate;
        this.generalAdmissionFee = generalAdmissionFee;
    }

    public Exhibition toExhibition() {
        Exhibition exhibition = new Exhibition();
        BeanUtils.copyProperties(this, exhibition);
        return exhibition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getGeneralAdmissionFee() {
        return generalAdmissionFee;
    }

    public void setGeneralAdmissionFee(BigDecimal generalAdmissionFee) {
        this.generalAdmissionFee = generalAdmissionFee;
    }

    @Override
    public String toString() {
        return "ExhibitionEntity{" +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", generalAdmissionFee=" + generalAdmissionFee +
                '}';
    }
}
