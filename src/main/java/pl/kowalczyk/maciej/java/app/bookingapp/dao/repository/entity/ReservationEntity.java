package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
//    private Long propertyId;

    @ManyToOne(cascade = CascadeType.ALL)
    private PropertyEntity property;

//    private String guestFirstName;
//    private String guestLastName;

    @Embedded
    private GuestEntity guest;

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

//    public Long getPropertyId() {
//        return propertyId;
//    }
//
//    public void setPropertyId(Long propertyId) {
//        this.propertyId = propertyId;
//    }

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }

    //    public GuestEntity getGuest() {
//        return guest;
//    }
//
//    public void setGuest(GuestEntity guest) {
//        this.guest = guest;
//    }


//    public String getGuestFirstName() {
//        return guestFirstName;
//    }
//
//    public void setGuestFirstName(String guestFirstName) {
//        this.guestFirstName = guestFirstName;
//    }

//    public String getGuestLastName() {
//        return guestLastName;
//    }
//
//    public void setGuestLastName(String guestLastName) {
//        this.guestLastName = guestLastName;
//    }


    public GuestEntity getGuest() {
        return guest;
    }

    public void setGuest(GuestEntity guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                ", property=" + property +
                ", guest=" + guest +
                '}';
    }
}

// TODO: 15.12.2023 Zaimplementować "automatyczne" dodawanie guest w reservation (add) 