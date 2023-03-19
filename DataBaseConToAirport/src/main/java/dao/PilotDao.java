package dao;

import model.Pilot;

import java.sql.SQLException;
import java.util.List;

public interface PilotDao {
    List<Pilot> findAll() throws SQLException;
    Pilot findById(int id) throws SQLException;
    void add(Pilot pilot);
    void updateById(Pilot pilot) throws SQLException;
    int deleteById(int id) throws SQLException;
}
