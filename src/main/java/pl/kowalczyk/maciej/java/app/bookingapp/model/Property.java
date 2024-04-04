package pl.kowalczyk.maciej.java.app.bookingapp.model;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private Long id;
    private String name;
    private Address address;
    private Host host;
    private List<Rental> rentals;

    public Property() {
        this.rentals = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public List<Rental> getRentals() {
        return this.rentals;
    }

    public void newRental(Guest guest, Reservation reservation) {
        rentals.add(new Rental(guest, reservation));
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", host=" + host +
                ", rentals=" + rentals +
                '}';
    }
}
