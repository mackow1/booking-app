package pl.kowalczyk.maciej.java.app.bookingapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Rental {

    private Guest guest;
    private Reservation reservation;

    public Rental(Guest guest, Reservation reservation) {
        this.guest = guest;
        this.reservation = reservation;
    }

    String createID() {
        String uniqueID = UUID.randomUUID().toString();
        LocalDateTime localDate = LocalDateTime.now();

        int day = localDate.getDayOfMonth();
        int hour = localDate.getHour();
        int minute = localDate.getMinute();

        return "" + minute + hour + day;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "guest=" + guest +
                ", reservation=" + reservation +
                '}';
    }
}
