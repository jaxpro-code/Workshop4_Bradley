package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Dealership {
    // dealership has a vehicle and vehicle is a color
    // dealership class has the object - vehicle class describes the object
    //<editor-fold desc="Dealership Constructor">
    private String Name;
    private String Address;
    private String Phone;
    private ArrayList<Vehicle> inventory;
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
// takes the vehicle object and adds it to the dealership list
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
// removes the vehicle object from the dealership list
    public void removeVehicles(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
// </editor-fold>

    // habveit in the constructor to add it to the inventory and removie it fromt the inventory
    public static void byPrice(){


    }

    public static void byMakeModel() {

    }

    public static void byYear() {

    }

    public static void byColor() {

    }

    public static void byMileage() {

    }

    public static void byType() {

    }

    public static void allVehicles(){

    }

}



