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
            e.printStackTrace();
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
        addressEntity.setCity("Wawa");
        addressEntity.setCountry("PL");

        AddressEntity addressEntityTwo = new AddressEntity();
        addressEntityTwo.setCity("Brn");
        addressEntityTwo.setCountry("DE");

        AddressEntity addressEntityThree = new AddressEntity();
        addressEntityThree.setCity("Kraków");
        addressEntityThree.setCountry("Polska");

        // when
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.save(addressEntity);
            session.save(addressEntityTwo);

            // TODO: 08.12.2023 Stworzyć sytuacje w której 2 rekordy zostaną dodane a następnie zostanie rzucony wyjątek
            // Sprawdzić czy wiersze zostały wycofane

//            double result = 1 / 0;
            session.save(addressEntityThree);
            session.getTransaction().commit();
        } catch (ArithmeticException e) {
            System.out.println("Rolling back!");
            session.getTransaction().rollback();
            e.printStackTrace();
        } catch (HibernateException e) {
            System.out.println("Rolling back!");
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

    // TODO: 13.12.2023 Zamienić try with resources na finally 

    @Test
    void read() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity("Prague");
        addressEntity.setCountry("Czech");
        AddressEntity addressRead = null;

        // when
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long savedId = (Long) session.save(addressEntity);

            addressRead = session.get(AddressEntity.class, savedId);
            System.out.println(addressRead);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }

        // then
        Assertions.assertNotNull(addressRead, "Address does not exist in database");
    }

    @Test
    void update() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        AddressEntity addressMerged = null;
        String city = "Rome";
        String country = "Italy";

        // when
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(addressEntity);

            System.out.println(addressEntity);

            addressEntity.setCity(city);
            addressEntity.setCountry(country);
            addressMerged = session.merge(addressEntity);

            System.out.println(addressMerged);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }

        // then
        Assertions.assertNotNull(addressMerged, "Address is null");
    }

    @Test
    void delete() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        AddressEntity addressDeleted = null;
        addressEntity.setCountry("France");
        addressEntity.setCity("Paris");

        // when
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long savedId = (Long) session.save(addressEntity);

            session.remove(addressEntity);

            addressDeleted = session.get(AddressEntity.class, savedId);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }

        // then
        Assertions.assertNull(addressDeleted, "Address still exists in database");
    }
}
