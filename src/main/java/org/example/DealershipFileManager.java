package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Dealership.*;
import org.example.Vehicle.*;

public class DealershipFileManager {
    // the file belongs to the object dealership
    public Dealership getDealership(){
        Dealership dealership = null;

    try{
        FileReader fileReader = new FileReader("src/main/resources/Vehicles.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String input;

        if((input = bufferedReader.readLine()) != null){
            String[] cvRow = input.split("\\|");
            dealership = new Dealership(cvRow[0],cvRow[1],cvRow[2]);
        }

        while((input = bufferedReader.readLine()) != null){
            String[] csvRow = input.split("\\|");
            int vin = Integer.parseInt(csvRow[0]);
            int year = Integer.parseInt(csvRow[1]);
            String make = csvRow[2];
            String model = csvRow[3];
            String type = csvRow[4];
            String color = csvRow[5];
            int odometer= Integer.parseInt(csvRow[6]);
            double price = Double.parseDouble(csvRow[7]);

            Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);
            dealership.addVehicle(vehicle);
        }

        bufferedReader.close();
    }
    catch (IOException ex) {
        System.out.println("there was a problem with this file ");
    }

    return dealership;
}
    public static void writeStock (Vehicle car){
        try {
            File file = new File("src/main/resources/Vehicle.csv");

            FileWriter fileWriter = new FileWriter(file, true);

            if (file.length() > 0) {
                fileWriter.write(System.lineSeparator());
            }

            fileWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%f", car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getType(),car.getColor(),car.getOdometer(),car.getPrice())
            );

            fileWriter.close();
        }
        catch (IOException ex){
            System.out.println("error writing to file");
        }
    }
}
