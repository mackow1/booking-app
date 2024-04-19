package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Reservation {

    private Long id;
    private String checkIn;
    private String checkOut;
    private int numberOfPersons;
    private Long propertyId;
//    private String guestFirstName;
//    private String guestLastName;

    private Guest guest;

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

//    public String getGuestFirstName() {
//        return guestFirstName;
//    }
//
//    public void setGuestFirstName(String guestFirstName) {
//        this.guestFirstName = guestFirstName;
//    }
//
//    public String getGuestLastName() {
//        return guestLastName;
//    }
//
//    public void setGuestLastName(String guestLastName) {
//        this.guestLastName = guestLastName;
//    }


    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                ", propertyId=" + propertyId +
                ", guest=" + guest +
                '}';
    }
}
