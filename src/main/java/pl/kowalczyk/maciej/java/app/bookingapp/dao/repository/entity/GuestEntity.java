package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GuestEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
    private List<Reservation> reservations = new ArrayList<>();

    public GuestEntity() {

    }

}
