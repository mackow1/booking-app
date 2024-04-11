package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Reservation {

    private Long id;
    private String checkIn;
    private String checkOut;
    private int numberOfPersons;
    private Long propertyId;

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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                ", propertyId=" + propertyId +
                '}';
    }
}
