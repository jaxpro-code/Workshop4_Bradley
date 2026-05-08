package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public static List<Vehicle> getStock(){
    List<Vehicle> getStock = new ArrayList<>();

    try{
        FileReader fileReader = new FileReader("src/main/resources/Vehicles.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String input;

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

            Vehicle car = new Vehicle(vin,year,make,model,type,color,odometer,price);
            getStock.add(car);
        }

        bufferedReader.close();
        return getStock;
    }
    catch (IOException ex) {
        System.out.println("there was a problem with this file ");
    }

    return new ArrayList<>();
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
