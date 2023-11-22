package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Reservation {

    private String checkIn;
    private String checkOut;
    private int numberOfPersons;

    public Reservation(String checkIn, String checkOut, int numberOfPersons) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
