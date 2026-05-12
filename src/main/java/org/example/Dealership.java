package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.example.UserInterface.*;

public class Dealership {
    // dealership has a vehicle and vehicle is a color
    // dealership class has the object - vehicle class describes the object
    //<editor-fold desc="Dealership Constructor">
    private String Name;
    private String Address;
    private String Phone;
    private final ArrayList<Vehicle> inventory;
    // new arry llist
    //  this. new aray tho

    public Dealership(String name, String address, String phone) {
        Name = name;
        Address = address;
        Phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    // </editor-fold>

    //<editor-fold desc="Dealership Methods">
// takes the vehicle object and adds it to the dealership list
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
// removes the vehicle object from the dealership list
    public void removeVehicles(int vin){
        for(Vehicle v : inventory){
            if(v.getVin() == vin){
                inventory.remove(v);
            }
        }
    }
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }
    public void byPrice(double min, double max){
        for(Vehicle v: inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                System.out.println(v.toString());
            }
        }
    }
    public void byMakeModel(String make, String model){
        for(Vehicle v:inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                System.out.println(v.toString());
            }
        }
    }
    public void byYear(int min, int max){
        for(Vehicle v : inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                System.out.println(v.toString());
            }
        }
    }
    public void byColor(String color) {
        for(Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                System.out.println(v.toString());
            }
        }
    }
    public void byMileage(int min, int max){
        for(Vehicle v : inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                System.out.println(v.toString());
            }
        }
    }
    public void byType(String type){
        for(Vehicle v : inventory){
            if(v.getType().equalsIgnoreCase(type)){
                System.out.println(v.toString());
            }
        }
    }
    //</editor-fold>

}



