package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    private static DatabaseConnection instance;
    public String url = DatabaseCredentials.getPropertyValue("url");
    public String user = DatabaseCredentials.getPropertyValue("user");
    public String password = DatabaseCredentials.getPropertyValue("password");

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

SELECT *
FROM RENTALS AS REN
LEFT JOIN RESERVATIONS AS RES
ON REN.RESERVATION_ID  = RES.ID;

SELECT *
FROM RESERVATIONS AS R
LEFT JOIN GUESTS AS G
ON R.GUEST_ID = G.ID
LEFT JOIN PROPERTIES AS P
ON R.PROPERTY_ID = P.ID;

SELECT * FROM GUESTS ;
-- Łączenie dwóch tabel za pomocą FK i PK
SELECT *
FROM GUESTS AS G
JOIN ADDRESSES AS A
ON G.ADDRESS_ID = A.ID;

 */

/*
SELECT * FROM ADDRESSES;
SELECT * FROM GUESTS;
SELECT * FROM RESERVATIONS;

-- Wyświetlić wszystkie rezerwacje z imieniem gościa i czasem pobytu

SELECT RESERVATIONS.ID, GUESTS.NAME, RESERVATIONS.DURATION
FROM RESERVATIONS
LEFT JOIN GUESTS ON RESERVATIONS.GUEST_ID = GUESTS.ID;

-- Wyświetlić wszystkie adresy zapisane w bazie oraz wszystkie imiona gości

SELECT ADDRESSES.NAME, GUESTS.NAME
FROM ADDRESSES
RIGHT JOIN GUESTS ON ADDRESSES.ID = GUESTS.ID;

-- Wyświetla wszystkie

SELECT *
FROM GUESTS AS G
LEFT JOIN ADDRESSES AS A
ON G.ADDRESS_ID = A.ID
RIGHT JOIN RESERVATIONS AS R
ON G.ID = R.GUEST_ID
ORDER BY G.NAME;
 */