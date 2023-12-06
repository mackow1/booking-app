package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AddressEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "streetName")
    private String street;

    @Column(name = "flatNumber")
    private String flatNumber;

    @Column(name = "cityName")
    private String city;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "voivodeship")
    private String voivodeship;

    @Column(name = "countryName")
    private String country;

    public AddressEntity() {
    }

}
