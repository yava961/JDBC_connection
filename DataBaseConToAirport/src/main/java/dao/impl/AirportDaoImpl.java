package dao.impl;

import dao.AirportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static connection.ConnectionToAirportData.getConnection;
import static queryConstant.Queries.*;

public class AirportDaoImpl implements AirportDao {
    public int clientAirportCanServe() throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(NUMBER_OF_SEATS);
        ResultSet resultSet = preparedStatement.executeQuery();
        int sum = 0;
        if (resultSet.next()) {
            sum = resultSet.getInt(1);
        }
        return sum;
    }
}
