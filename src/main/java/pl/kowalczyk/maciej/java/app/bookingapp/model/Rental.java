package pl.kowalczyk.maciej.java.app.bookingapp.model;

import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RentalStatus;

public class Rental {

    private Long id;

    private String checkIn;
    private String checkOut;
    private int numberOfPersons;

    private Property property;
    private Guest guest;
    private Reservation reservation;
    private RentalStatus status = RentalStatus.NEW;

    public Rental() {
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                ", property=" + property +
                ", guest=" + guest +
                ", reservation=" + reservation +
                ", status=" + status +
                '}';
    }
}
