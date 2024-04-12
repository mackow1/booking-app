package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HostEntityTest {

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
    void createHostWithAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry("Poland");
        addressEntity.setCity("Poznan");

        HostEntity hostEntity = new HostEntity();
        hostEntity.setName("Marcin");
        hostEntity.setEmail("fsda@gd.com");
//        hostEntity.setAddress(addressEntity);

        Long savedHostId = null;

        // when
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(addressEntity);
            savedHostId = (Long) session.save(hostEntity);

//            hostRead = session.get(HostEntity.class, savedHostId);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // then
        Assertions.assertNotNull(savedHostId, "Host was not created");
    }

}