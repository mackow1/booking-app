package pl.kowalczyk.maciej.java.app.bookingapp.model;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RentalEntity;

import java.util.HashSet;
import java.util.Set;

public class Property {

    private Long id;
    private String name;
    private Address address;
    private Long hostId;
    private Host host;
    private Set<RentalEntity> rentals = new HashSet<>();

    public Property() {
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

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Set<RentalEntity> getRentals() {
        return this.rentals;
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
