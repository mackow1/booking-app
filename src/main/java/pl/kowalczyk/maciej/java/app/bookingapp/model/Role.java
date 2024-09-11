package pl.kowalczyk.maciej.java.app.bookingapp.model;

import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;

public class Role {

    private Long id;
    private RoleType name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
