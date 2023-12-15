package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;

@Entity
public class RentalEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private GuestEntity guest;

    @OneToOne
    private ReservationEntity reservation;

    public RentalEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
