package service;

import dao.AirportDao;
import dao.PilotDao;
import dao.impl.AirportDaoImpl;
import dao.impl.PilotDaoImpl;
import model.Pilot;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class AirportServiceImpl implements AirportService {
    private PilotDao pilotDao = new PilotDaoImpl();
    private AirportDao airportDao = new AirportDaoImpl();

    @Override
    public List<Pilot> findAllPilots() throws SQLException {
        return pilotDao.findAll();
    }
    @Override
    public Pilot getPilotById(Scanner scanner) throws SQLException {
        System.out.println("Enter pilot id you want to find : ");
        int pilotId = scanner.nextInt();
        scanner.nextLine();
        return new PilotDaoImpl().findById(pilotId);
    }
    @Override
    public void addNewPilot(Scanner scanner) throws SQLException{
        System.out.println("Enter pilot name: ");
        String name = scanner.nextLine();
        System.out.println("Enter pilot age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter plane that pilot can use: ");
        String plane = scanner.nextLine();
        pilotDao.add(new Pilot(name, age, plane));

    }
    @Override
    public void updatePilotById(Scanner scanner) throws SQLException{
        System.out.println("Enter pilot id to update");
        int pilotId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new Pilot name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new Pilot age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new plane Pilot can fly: ");
        String plane = scanner.nextLine();
        pilotDao.updateById(new Pilot(pilotId,name,age,plane));
    }
    @Override
    public void deletePilotById(Scanner scanner) throws SQLException{
        System.out.println("Enter Pilot id you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        pilotDao.deleteById(id);
    }
    @Override
    public int calculateTotalPassengersAmount() throws SQLException {
        return airportDao.clientAirportCanServe();
    }



}
