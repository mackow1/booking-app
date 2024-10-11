package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "HOSTS")
public class HostEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

//    @OneToOne
//    private AddressEntity address;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private Set<PropertyEntity> properties;

    public HostEntity() {
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

//    public AddressEntity getAddress() {
//        return address;
//    }
//
//    public void setAddress(AddressEntity address) {
//        this.address = address;
//    }

    public Set<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(Set<PropertyEntity> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "HostEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
//                ", address=" + address +
                '}';
    }
}
