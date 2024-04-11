package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVATIONS")
public class ReservationEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String checkIn;
    private String checkOut;
    private int numberOfPersons;
    private Long propertyId;

//    @ManyToOne
//    private GuestEntity guest;

    public ReservationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

//    public GuestEntity getGuest() {
//        return guest;
//    }
//
//    public void setGuest(GuestEntity guest) {
//        this.guest = guest;
//    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", numberOfPersons=" + numberOfPersons + '\'' +
                ", propertyId=" + propertyId +
                '}';
    }
}

// TODO: 15.12.2023 Zaimplementować "automatyczne" dodawanie guest w reservation (add) 