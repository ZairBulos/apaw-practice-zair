package es.upm.miw.apaw_practice.domain.models;

import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;
import es.upm.miw.apaw_practice.domain.models.museum.ExhibitionSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExhibitionTest {
    private ExhibitionSorter exhibitionSorter;
    private List<Exhibition> exhibitions;

    @BeforeEach
    void setUp() {
        exhibitionSorter = new ExhibitionSorter();

        this.exhibitions = List.of(
                new Exhibition("Spanish authors", LocalDate.of(2025, 8, 25), BigDecimal.valueOf(20.00)),
                new Exhibition("Impressionist Wonders", LocalDate.of(2025, 8, 21), BigDecimal.valueOf(35.00)),
                new Exhibition("The Renaissance Masters", LocalDate.of(2025, 10, 15), BigDecimal.valueOf(15.00))
        );
    }

    @Test
    void testSortByGeneralAdmissionFeeAscending() {
        Stream<Exhibition> sortedStream = exhibitionSorter.sort(
                exhibitions.stream(),
                Comparator.comparing(Exhibition::getGeneralAdmissionFee).reversed()
        );

        List<Exhibition> sortedList = sortedStream.toList();
        assertEquals(BigDecimal.valueOf(35.00), sortedList.get(0).getGeneralAdmissionFee());
        assertEquals(BigDecimal.valueOf(20.00), sortedList.get(1).getGeneralAdmissionFee());
        assertEquals(BigDecimal.valueOf(15.00), sortedList.get(2).getGeneralAdmissionFee());
    }

    @Test
    void testSortByGeneralAdmissionFeeDescending() {
        Stream<Exhibition> sortedStream = exhibitionSorter.sort(
                exhibitions.stream(),
                Comparator.comparing(Exhibition::getGeneralAdmissionFee)
        );

        List<Exhibition> sortedList = sortedStream.toList();
        assertEquals(BigDecimal.valueOf(15.00), sortedList.get(0).getGeneralAdmissionFee());
        assertEquals(BigDecimal.valueOf(20.00), sortedList.get(1).getGeneralAdmissionFee());
        assertEquals(BigDecimal.valueOf(35.00), sortedList.get(2).getGeneralAdmissionFee());
    }

    @Test
    void testSortByStartDateAscending() {
        Stream<Exhibition> sortedStream = exhibitionSorter.sort(
                exhibitions.stream(),
                Comparator.comparing(Exhibition::getStartDate)
        );

        List<Exhibition> sortedList = sortedStream.toList();
        assertEquals(LocalDate.of(2025, 8, 21), sortedList.get(0).getStartDate());
        assertEquals(LocalDate.of(2025, 8, 25), sortedList.get(1).getStartDate());
        assertEquals(LocalDate.of(2025, 10, 15), sortedList.get(2).getStartDate());
    }

    @Test
    void testSortByTitleDescending() {
        Stream<Exhibition> sortedStream = exhibitionSorter.sort(
                exhibitions.stream(),
                Comparator.comparing(Exhibition::getTitle).reversed()
        );

        List<Exhibition> sortedList = sortedStream.toList();
        assertEquals("The Renaissance Masters", sortedList.get(0).getTitle());
        assertEquals("Spanish authors", sortedList.get(1).getTitle());
        assertEquals("Impressionist Wonders", sortedList.get(2).getTitle());
    }
}
