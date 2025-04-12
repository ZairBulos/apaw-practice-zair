package es.upm.miw.apaw_practice.domain.models.museum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Exhibition {
    private String title;
    private LocalDate startDate;
    private BigDecimal generalAdmissionFee;

    public Exhibition() {
        // empty for framework
    }

    public Exhibition(String title, LocalDate startDate, BigDecimal generalAdmissionFee) {
        this.title = title;
        this.startDate = startDate;
        this.generalAdmissionFee = generalAdmissionFee;
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
        return "Exhibition{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", generalAdmissionFee=" + generalAdmissionFee +
                '}';
    }
}
