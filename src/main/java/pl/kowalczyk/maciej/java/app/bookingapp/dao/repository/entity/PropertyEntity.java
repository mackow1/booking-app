package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class PropertyEntity {

    // TODO: 13.12.2023 Dodać relację do addresu jak w classie GuestEntity + test 

    // TODO: 13.12.2023 Dodać relację do rentals jak w klasie GuestEntity 

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne
    private AddressEntity address;

    @OneToOne
    private HostEntity host;

    @OneToMany
    private List<RentalEntity> rentals;

    public PropertyEntity() {
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public HostEntity getHost() {
        return host;
    }

    public void setHost(HostEntity host) {
        this.host = host;
    }

    public List<RentalEntity> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalEntity> rentals) {
        this.rentals = rentals;
    }
}
