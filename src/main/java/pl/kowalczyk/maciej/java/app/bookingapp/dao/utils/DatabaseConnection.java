package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    private static DatabaseConnection instance;
    public String url = "jdbc:h2:~/test";
    public String user = "sa";
    public String password = "";

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        LOGGER.info("getInstance()");
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        LOGGER.info("getInstance(...) = " + instance);
        return instance;
    }

    public Connection getConnection() throws SQLException {
        LOGGER.info("getInstance()");
        Connection connection = DriverManager.getConnection(url, user, password);
        LOGGER.info("getInstance(...) = " + connection);
        return connection;
    }
}

// TODO: 28.11.2023
// Dodać loggery

// TODO: 28.11.2023 PD
// Stworzyć oddzielną klasse pobierającą namiary na bazę danych/credentials z pliku properties
// https://docs.oracle.com/javase/tutorial/essential/environment/properties.html

// TODO: 28.11.2023 PD
// Przećwiczyć left join i right join i przygotować przykłady dla joinów

/*
-- public class Test{
--    private int id;
--    private String name;
-- }
CREATE TABLE TEST(
    ID INT PRIMARY KEY,
    NAME VARCHAR(255)
);

-- public class Address {
--     private int id;
--     private String street;
-- }

CREATE TABLE ADDRESSES (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255)
);

-- public class Guest {
--     private int id;
--     private String name;
--     private Address address;
-- }

CREATE TABLE GUESTS (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    ADDRESS_ID INT,
    foreign key (ADDRESS_ID) references ADDRESSES(ID)
);

INSERT INTO ADDRESSES VALUES(1, 'Warszawska 1');
INSERT INTO ADDRESSES(ID, NAME) VALUES(2, 'Warszawska 6');

SELECT * FROM ADDRESSES ;

INSERT INTO GUESTS( ID, NAME , ADDRESS_ID ) VALUES (1, 'Maciek', null);
INSERT INTO GUESTS( ID, NAME , ADDRESS_ID ) VALUES (2, 'Piotr', 2);

SELECT * FROM GUESTS ;
-- Łączenie dwóch tabel za pomocą FK i PK
SELECT *
FROM GUESTS AS G
JOIN ADDRESSES AS A
ON G.ADDRESS_ID = A.ID;

 */

