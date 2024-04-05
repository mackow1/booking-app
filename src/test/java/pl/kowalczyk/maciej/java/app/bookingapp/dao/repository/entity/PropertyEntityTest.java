package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyEntityTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .buildMetadata()
                            .buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Test
    void createPropertyWithHostAndAddress() {
        // given
        PropertyEntity propertyRead = null;
        PropertyEntity property = new PropertyEntity();

        AddressEntity address = new AddressEntity();
        address.setCity("Zakopane");
        address.setCountry("Polska");

        HostEntity host = new HostEntity();
        host.setName("Michał");
        host.setPhoneNumber("23436456");

        property.setAddress(address);
        property.setHost(host);

        // when
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

//            session.save(address);
            session.save(host);
            Long savedId = (Long) session.save(property);
            propertyRead = session.get(PropertyEntity.class, savedId);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // then
        PropertyEntity finalPropertyRead = propertyRead;
        Assertions.assertAll(
                () -> Assertions.assertNotNull(finalPropertyRead, "Property is not created"),
                () -> Assertions.assertNotNull(finalPropertyRead.getAddress(), "Address of the property is NULL")
        );
    }
}
