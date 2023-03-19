package dao.impl;

import dao.PilotDao;
import model.Pilot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static connection.ConnectionToAirportData.getConnection;
import static queryConstant.Queries.*;

public class PilotDaoImpl implements PilotDao {
    private static final String ID_COLUMN_NAME = "id";
    private static final String NAME_COLUMN = "name";
    private static final String AGE_COLUMN_NAME = "age";
    private static final String PLANES_COLUMN_NAME = "planes";

    @Override
    public List<Pilot> findAll() throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ALL_PILOTS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Pilot> pilots = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(ID_COLUMN_NAME);
            String name = resultSet.getString(NAME_COLUMN);
            int age = resultSet.getInt(AGE_COLUMN_NAME);
            String planes = resultSet.getString(PLANES_COLUMN_NAME);
            pilots.add(new Pilot(id, name, age, planes));
        }
        return pilots;
    }

    @Override
    public Pilot findById(int id) throws SQLException {

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(PILOT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        ;
        Pilot pilot = null;
        while (resultSet.next()) {
            pilot = new Pilot(resultSet.getInt(ID_COLUMN_NAME),
                    resultSet.getString(NAME_COLUMN),
                    resultSet.getInt(AGE_COLUMN_NAME),
                    resultSet.getString(PLANES_COLUMN_NAME)
            );
        }
        return pilot;
    }

    @Override
    public void add(Pilot pilot) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PILOT);
            preparedStatement.setString(1, pilot.getName());
            preparedStatement.setInt(2, pilot.getAge());
            preparedStatement.setString(3, pilot.getPlanes());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public void updateById(Pilot pilot) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PILOT);
            preparedStatement.setString(1, pilot.getName());
            preparedStatement.setInt(2, pilot.getAge());
            preparedStatement.setString(3, pilot.getPlanes());
            preparedStatement.setInt(4, pilot.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public int deleteById(int id) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PILOT);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }
}


