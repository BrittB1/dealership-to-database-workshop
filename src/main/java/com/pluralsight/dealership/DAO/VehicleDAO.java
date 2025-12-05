package com.pluralsight.dealership.DAO;

import com.pluralsight.dealership.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    private BasicDataSource bds;

    public VehicleDAO() {
        this.bds = DataSource.getBds();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

        try (Connection c = bds.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            // converts current row --> vehicle object
            while (rs.next()) {
                Vehicle v = newVehicleFromResults(rs);
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle newVehicleFromResults(ResultSet rs) throws SQLException {
        int vin = rs.getInt("vin");
        int year = rs.getInt("year");
        String make = rs.getString("make");
        String model = rs.getString("model");
        String vehicleType = rs.getString("vehicle_type");
        String color = rs.getString("color");
        int odometer = rs.getInt("odometer");
        double price = rs.getDouble("price");

        return new Vehicle(vin, year, odometer, make, model, color, vehicleType, price);
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles WHERE make = ? AND model = ?";

        try (Connection c = bds.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, make);
            ps.setString(2, model);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vehicle v = newVehicleFromResults(rs);
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";

        try (Connection c = bds.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vehicle v = newVehicleFromResults(rs);
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles WHERE color = ?";

        try (Connection c = bds.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, color);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vehicle v = newVehicleFromResults(rs);
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?";

        try (Connection c = bds.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vehicle v = newVehicleFromResults(rs);
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles WHERE vehicle_type = ?";

        try (Connection c = bds.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, type);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vehicle v = newVehicleFromResults(rs);
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles";

        try (Connection c = bds.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vehicle v = newVehicleFromResults(rs);
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}