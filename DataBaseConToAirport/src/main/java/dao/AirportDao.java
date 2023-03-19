package dao;

import java.sql.SQLException;

public interface AirportDao {
    int clientAirportCanServe() throws SQLException;
}
