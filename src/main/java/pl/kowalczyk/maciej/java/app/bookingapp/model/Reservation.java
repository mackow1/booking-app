package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Reservation {

    private String checkIn;
    private String checkOut;
    private int numberOfPersons;

    public Reservation() {
    }

    public Reservation(String checkIn, String checkOut, int numberOfPersons) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfPersons = numberOfPersons;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                '}';
    }
}
