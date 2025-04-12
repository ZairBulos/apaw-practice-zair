package es.upm.miw.apaw_practice.domain.models.museum;

import java.util.Comparator;
import java.util.stream.Stream;

public class ExhibitionSorter {

    public Stream<Exhibition> sort(Stream<Exhibition> exhibitions, Comparator<Exhibition> strategy) {
        return exhibitions.sorted(strategy);
    }
}
