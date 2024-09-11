package pl.kowalczyk.maciej.java.app.bookingapp.model;

import pl.kowalczyk.maciej.java.app.bookingapp.api.core.ReservationStatus;

public class Reservation {

    private Long id;
    private String checkIn;
    private String checkOut;
    private int numberOfPersons;
    private Long propertyId;

    private Property property;
    private Guest guest;
    private ReservationStatus status = ReservationStatus.NEW;

    public Reservation() {
    }

    public Reservation(String checkIn, String checkOut, int numberOfPersons) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfPersons = numberOfPersons;
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

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                ", propertyId=" + propertyId +
                ", property=" + property +
                ", guest=" + guest +
                ", status=" + status +
                '}';
    }
}
