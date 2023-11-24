package pl.kowalczyk.maciej.java.app.bookingapp.dao.utils;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private String url = "jdbc:h2:~/test";
    private String user = "sa";
    private String password = "";

    private DatabaseConnection() {

    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}
