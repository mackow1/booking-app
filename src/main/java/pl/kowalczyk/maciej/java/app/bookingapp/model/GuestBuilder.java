package pl.kowalczyk.maciej.java.app.bookingapp.model;

import java.util.ArrayList;
import java.util.List;

public class GuestBuilder {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
    private List<Reservation> reservations = new ArrayList<>();

    public GuestBuilder addId(Long id) {
        this.id = id;
        return this;
    }

    public GuestBuilder addName(String name) {
        this.name = name;
        return this;
    }

    public GuestBuilder addEmail(String email) {
        this.email = email;
        return this;
    }

    public GuestBuilder addPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public GuestBuilder addAddress(Address address) {
        this.address = address;
        return this;
    }

    public GuestBuilder addListOfReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }
}
