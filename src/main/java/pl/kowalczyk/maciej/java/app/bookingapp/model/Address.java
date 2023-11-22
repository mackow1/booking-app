package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Address {

    //    private String address;
    private String street;
    private String flatNumber;
    private String city;
    private String postalCode;
    private String voivodeship;
    private String country;

    public Address() {
    }

    public Address(String street, String flatNumber, String city, String postalCode, String voivodeship, String country) {
        this.street = street;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.voivodeship = voivodeship;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", voivodeship='" + voivodeship + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
