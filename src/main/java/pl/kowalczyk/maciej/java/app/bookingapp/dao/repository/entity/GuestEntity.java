package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GuestEntity {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
    private List<Reservation> reservations = new ArrayList<>();

}
