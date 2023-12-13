package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    private AddressEntity address;
//    private List<Reservation> reservations = new ArrayList<>();

    public GuestEntity() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
