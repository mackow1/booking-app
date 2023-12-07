package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Address;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;

import java.util.List;

@Entity
public class PropertyEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
//    private Address address;
//    private Host host;
//    private List<Rental> rentals;

    public PropertyEntity() {
    }
}
