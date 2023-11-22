package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Host {

    private String name;
    private String email;
    private String phoneNumber;

//    private String address;
//    private String street;
//    private String flatNumber;
//    private String city;
//    private String postalCode;
//    private String voivodeship;
//    private String country;

    private Address address;

    public Host(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Host{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
