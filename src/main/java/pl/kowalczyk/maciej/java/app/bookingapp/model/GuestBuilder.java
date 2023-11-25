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


}
