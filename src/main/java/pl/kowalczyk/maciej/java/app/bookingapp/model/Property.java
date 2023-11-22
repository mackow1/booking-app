package pl.kowalczyk.maciej.java.app.bookingapp.model;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private String name;
    private Address address;
    private Host host;
    private List<Rental> rentals;

    public Property() {
        this.rentals = new ArrayList<>();
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }

    public Rental rent() {
        System.out.println("renting a property");
        return null;
    }

    public void newRental(Guest guest, Reservation reservation) {
        rentals.add(new Rental(guest, reservation));
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", host=" + host +
                ", rentals=" + rentals +
                '}';
    }
}
