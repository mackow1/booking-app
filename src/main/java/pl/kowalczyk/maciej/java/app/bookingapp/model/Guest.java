package pl.kowalczyk.maciej.java.app.bookingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Guest {

    private static final Logger LOGGER = Logger.getLogger(Guest.class.getName());

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
    private List<Reservation> reservations = new ArrayList<>();

    public Guest() {

    }

    public Guest(Long id, String name, String email, String phoneNumber, Address address, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.reservations = reservations;
    }

    public Reservation makeReservation(String checkIn, String checkOut, int numberOfPersons) {
//        System.out.println("makeReservation(" + checkIn + ", " + checkOut + ", " + numberOfPersons + ")");
        LOGGER.info("makeReservation(" + checkIn + ", " + checkOut + ", " + numberOfPersons + ")");

        reservations.add(new Reservation(checkIn, checkOut, numberOfPersons));
        Reservation reservation = reservations.get(reservations.size() - 1);

//        System.out.println("makeReservation(...) = " + reservation);
        LOGGER.info("makeReservation(...) = " + reservation);
        return reservation;
    }

    public Reservation reservation(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    public Reservation cancelReservation() {
        return reservations.remove(reservations.size() - 1);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", reservations=" + reservations +
                '}';
    }

}
