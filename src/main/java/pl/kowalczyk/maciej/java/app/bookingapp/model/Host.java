package pl.kowalczyk.maciej.java.app.bookingapp.model;

public class Host {

    private Long id;
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

//    private Address address;

    public Host() {
    }

    public Host(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    @Override
    public String toString() {
        return "Host{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
//                ", address=" + address +
                '}';
    }
}
