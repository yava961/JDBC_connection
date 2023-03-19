package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionToAirportData {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(ConnectionConstant.URL, ConnectionConstant.USER, ConnectionConstant.PASS);
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return connection;
    }
}


