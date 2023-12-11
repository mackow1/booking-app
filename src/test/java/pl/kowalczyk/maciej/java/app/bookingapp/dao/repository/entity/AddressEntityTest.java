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

class AddressEntityTest {

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

    // TODO: 05.12.2023 PD
    // Dodać wszystko do git

    // Stworzyć nowe encje, napisać testy
    // Nowa własna encja z dodatkowymi kolumnami

    @Test
    void create() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity("Warszawa");
        addressEntity.setCountry("Polska");

        AddressEntity addressEntityTwo = new AddressEntity();
        addressEntityTwo.setCity("Warszawa2");
        addressEntityTwo.setCountry("Polska2");

        AddressEntity addressEntityThree = new AddressEntity();
        addressEntityThree.setCity("Warszawa3");
        addressEntityThree.setCountry("Polska3");

        // when
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.save(addressEntity);
            session.save(addressEntityTwo);

            // TODO: 08.12.2023 Stworzyć sytuacje w której 2 rekordy zostaną dodane a następnie zostanie rzucony wyjątek
            // Sprawdzić czy wiersze zostały wycofane

            session.getTransaction().commit();
            session.save(addressEntityThree);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // then

        Assertions.assertAll(
                () -> Assertions.assertNotNull(addressEntity.getId(), "Id is null")
        );
    }

}