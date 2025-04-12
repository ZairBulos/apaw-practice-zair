package es.upm.miw.apaw_practice.domain.models.museum;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class MuseumPublisher<T> {
    private Set<Consumer<T>> consumers;

    public MuseumPublisher() {
        this.consumers = new HashSet<>();
    }

    public void subscribe(Consumer<T> consumer) {
        this.consumers.add(consumer);
    }

    public void unsubscribe(Consumer<T> consumer) {
        this.consumers.remove(consumer);
    }

    public void next(T value) {
        this.consumers.forEach(consumer -> consumer.accept(value));
    }
}
