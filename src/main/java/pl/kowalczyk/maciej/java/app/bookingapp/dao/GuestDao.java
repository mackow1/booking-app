package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import pl.kowalczyk.maciej.java.app.bookingapp.dao.utils.DatabaseConnection;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.utils.UniqueId;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Guest;
import pl.kowalczyk.maciej.java.app.bookingapp.model.GuestBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuestDao {

    private static final Logger LOGGER = Logger.getLogger(GuestDao.class.getName());

    public List<Guest> list() {

        List<Guest> listOfGuests = new ArrayList<>();
        LOGGER.info("list()");

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST");

            while (resultSet.next()) {
                long id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");

                listOfGuests.add(new GuestBuilder()
                        .addId(id)
                        .addName(name)
                        .build());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("list() = " + listOfGuests);
        return listOfGuests;
    }

    public Guest create(Guest guest) {

        LOGGER.info("create(" + guest + ")");
        Guest createdGuest = null;
        long uniqueId = UniqueId.generate();

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TEST VALUES(?, ?)")) {

            preparedStatement.setLong(1, uniqueId);
            preparedStatement.setString(2, guest.getName());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                createdGuest = new GuestBuilder()
                        .addId(uniqueId)
                        .addName(guest.getName())
                        .build();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        LOGGER.info("create(...) = " + createdGuest);
        return createdGuest;
    }

    public Guest read(int id) {

        LOGGER.info("read(" + id + ")");
        Guest guestFound = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TEST WHERE ID = ?")) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // przypisać wartości do guest
                int guestId = resultSet.getInt("ID");
                String guestName = resultSet.getString("NAME");

                LOGGER.info("read(...) = " + guestFound);
            } else {
                LOGGER.info("read(...) = Guest not found in database");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestFound;
    }

    public Guest update(int id, String name) {
        LOGGER.info("update(id: " + id + ", name: " + name + ")");
        Guest guestUpdated = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TEST SET NAME = ? WHERE ID = ?")) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                LOGGER.info("update(...) = " + guestUpdated);
            } else {
                LOGGER.info("update(...) = Guest not updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guestUpdated;
    }

    public Guest delete(int id) {
        LOGGER.info("delete(" + id + ")");
        Guest guestDeleted = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM TEST WHERE ID = ?")) {

            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                LOGGER.info("delete(...) = " + guestDeleted + " DELETED");
            } else {
                LOGGER.info("delete(...) = Guest not deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guestDeleted;
    }
}
