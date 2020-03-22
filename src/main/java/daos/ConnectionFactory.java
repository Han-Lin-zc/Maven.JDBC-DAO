package daos;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    public static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

    public static final String URL = "jdbc:mysql://localhost:3306/car?serverTimezone=UTC";
    public static final String USER = "hanlin";
    public static final String PASS = "pass";


    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            LOGGER.log(Level.INFO, "It works!");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.info("NOT WORKING " + e);
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}
