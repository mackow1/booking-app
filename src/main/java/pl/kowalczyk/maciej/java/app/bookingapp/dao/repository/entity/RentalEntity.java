package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

@Entity
public class RentalEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Guest guest;
//    private Reservation reservation;

    public RentalEntity() {
    }
}
