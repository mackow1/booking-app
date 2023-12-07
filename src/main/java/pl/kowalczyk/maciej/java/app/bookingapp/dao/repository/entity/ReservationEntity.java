package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String checkIn;
    private String checkOut;
    private int numberOfPersons;

    public ReservationEntity() {
    }
}
