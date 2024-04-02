package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Address {

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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
