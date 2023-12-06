package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String flatNumber;
    private String city;
    private String postalCode;
    private String voivodeship;
    private String country;

    public AddressEntity() {
    }

}
