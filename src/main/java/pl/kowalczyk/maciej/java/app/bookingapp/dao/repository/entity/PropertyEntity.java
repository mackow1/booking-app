package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROPERTIES")
public class PropertyEntity {

    // TODO: 13.12.2023 Dodać relację do addresu jak w classie GuestEntity + test 

    // TODO: 13.12.2023 Dodać relację do rentals jak w klasie GuestEntity 

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private HostEntity host;

//    @OneToMany(fetch = FetchType.LAZY)
//    private Set<RentalEntity> rentals = new HashSet<>();

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

//    public Set<RentalEntity> getRentals() {
//        return rentals;
//    }
//
//    public void setRentals(Set<RentalEntity> rentals) {
//        this.rentals = rentals;
//    }

    @Override
    public String toString() {
        return "PropertyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", host=" + host +
//                ", rentals=" + rentals +
                '}';
    }
}
