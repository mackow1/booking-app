package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RentalStatus;

@Entity
@Table(name = "RENTALS")
public class RentalEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String checkIn;
    private String checkOut;
    private int numberOfPersons;

    @OneToOne
    private PropertyEntity property;

    @OneToOne
    private GuestEntity guest;

    @OneToOne
    private ReservationEntity reservation;

    @Enumerated(EnumType.STRING)
    private RentalStatus status = RentalStatus.NEW;

    public RentalEntity() {
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

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }

    public GuestEntity getGuest() {
        return guest;
    }

    public void setGuest(GuestEntity guest) {
        this.guest = guest;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
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
        return "RentalEntity{" +
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
