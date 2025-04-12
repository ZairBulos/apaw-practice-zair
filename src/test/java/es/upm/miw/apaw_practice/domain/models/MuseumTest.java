package es.upm.miw.apaw_practice.domain.models;

import es.upm.miw.apaw_practice.domain.models.museum.Museum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MuseumTest {
    private Museum museum;
    private StringBuilder notificationResult;

    @BeforeEach
    void setUp() {
        this.museum = new Museum();
        this.museum.setName("Art Museum");
        this.museum.setOpened(false);

        this.notificationResult = new StringBuilder();
    }

    @Test
    void testPublisherSubscribe() {
        Consumer<Boolean> subscriber = isOpened -> notificationResult.append("State changed to: ").append(isOpened);
        this.museum.getPublisher().subscribe(subscriber);

        this.museum.setOpened(!this.museum.getOpened());

        assertEquals("State changed to: " + true, notificationResult.toString());
    }

    @Test
    void testPublisherUnsubscribe() {
        Consumer<Boolean> subscriber = isOpened -> notificationResult.append("State changed to: ").append(isOpened);
        this.museum.getPublisher().subscribe(subscriber);

        this.museum.getPublisher().unsubscribe(subscriber);
        this.museum.setOpened(!this.museum.getOpened());

        assertEquals("", notificationResult.toString());
    }
}
