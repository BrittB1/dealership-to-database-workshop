package com.pluralsight.dealership.models;


import com.pluralsight.dealership.DAO.VehicleDAO;

import java.util.List;

public class Dealership {

// knows how to search; runs logic and returns results to the UI so it can display them

    private String dealershipName, address, phoneNum;
    private VehicleDAO vehicleDAO;

    public Dealership(String dealershipName, String address, String phoneNum) {
        this.dealershipName = dealershipName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.vehicleDAO = new VehicleDAO();
    }

        public String getDealershipName() {
            return dealershipName;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return vehicleDAO.getVehiclesByPrice(min, max);
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return vehicleDAO.getVehiclesByMakeModel(make, model);
        }

        public List<Vehicle> getVehiclesByYear(int min, int max) {
            return vehicleDAO.getVehiclesByYear(min, max);
        }

        public List<Vehicle> getVehiclesByColor(String color) {
            return vehicleDAO.getVehiclesByColor(color);
        }

        public List<Vehicle> getVehiclesByMileage(int min, int max) {
            return vehicleDAO.getVehiclesByMileage(min, max);
        }

        public List<Vehicle> getVehiclesByType(String vehicleType) {
            return vehicleDAO.getVehiclesByType(vehicleType);
        }

        public List<Vehicle> getAllVehicles() {
            return vehicleDAO.getAllVehicles();
        }

        public void addVehicle(Vehicle vehicle) {

            this.inventory.add(vehicle);
        }

        public void removeVehicle(Vehicle vehicle) {

            this.inventory.remove(vehicle);
        }
    }

