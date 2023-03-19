package service;

import model.Pilot;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface AirportService {
    List<Pilot> findAllPilots() throws SQLException;
    Pilot getPilotById(Scanner scanner) throws SQLException;
    void addNewPilot(Scanner scanner) throws SQLException;
    void updatePilotById(Scanner scanner) throws SQLException;
    void deletePilotById(Scanner scanner) throws SQLException;
    int calculateTotalPassengersAmount() throws SQLException;


}
