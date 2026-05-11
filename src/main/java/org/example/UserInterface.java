package org.example;

import java.util.Scanner;
import org.example.Dealership.*;
public class UserInterface {
    //the menus and the confirmations
    //to strings - vin|year|make|modle|type|color|odometer|price
    //while loop
//<editor-fold desc="fix it ">
    static Dealership dealership = new Dealership("Painters Garage","1002 Main Street","803-209-6747");
    Scanner scanner = new Scanner(System.in);


    // </editor-fold>

//<editor-fold desc="UserInterface Methods">
    public static void menu(){
        System.out.println("1) List All Vehicles"+
                "\n2)"+
                "\n3)" +
                "\n4)"+
                "\n5)"+
                "\n6)"+
                "\n7)"+
                "\n8)"+
                "\n9)");
    }
    public static void uiAddVehicle(Scanner scanner){
        System.out.println("Lets add a Vehicle\n"+
                "Enter the last 5 digits of the Vin Number");
        int vin = scanner.nextInt();
        System.out.println("Enter the Vehicles Year");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Vehicles Make");
        String make = scanner.nextLine();
        System.out.println("Enter the Vehicles Model");
        String model = scanner.nextLine();
        System.out.println("Enter the Vehicles Type");
        String type = scanner.nextLine();
        System.out.println("Enter the Vehicles Color");
        String color = scanner.nextLine();
        System.out.println("Enter the Vehicles Mileage");
        int odometer = scanner.nextInt();
        System.out.println("Enter the Vehicle Price");
        double price = scanner.nextDouble();
        Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);
        dealership.addVehicle(vehicle);
        System.out.println("The Vehicle has been added to the Inventory");
    }
    public static void uiRemoveVehicle(Scanner scanner){
        System.out.println("Which Vehicle would you like to Remove"+
                "Enter the Vin");
        int vin = scanner.nextInt();
        dealership.removeVehicles(vin);
        System.out.println("The Vehicle has been removed from the Inventory");
    }
    public static void uiAllVehicle(){
        for(Vehicle V : dealership.getAllVehicles()){
            V.toString();
        }
    }
    public static void uiByPrice(Scanner scanner){
        System.out.println("What is the Min of the Vehicle Price Range?");
        double min = scanner.nextDouble();
        System.out.println("What is the Max of the Vehicle Price Range?");
        double max = scanner.nextDouble();
        dealership.byPrice(min,max);
    }
    public static void uiByMakeModel(Scanner scanner){
        System.out.println("What is the Make of the Vehicle you're looking for?");
        String make = scanner.nextLine();
        System.out.println("What is the Model of the Vehicle you're looking for?");
        String model = scanner.nextLine();
        dealership.byMakeModel(make,model);
    }
    public static void uiByYear(Scanner scanner){
        System.out.println("What is the min Year of the Vehicle you're looking for?");
        int min = scanner.nextInt();
        System.out.println("What is the max Year of the Vehicle you're looking for? ");
        int max = scanner.nextInt();
        dealership.byYear(min,max);
    }
    public static void uiByColor(Scanner scanner){
        System.out.println("What is the color of Vehicle you're looking for?");
        String color = scanner.nextLine();
        dealership.byColor(color);
    }
    public static void uiByMileage(Scanner scanner){
        System.out.println("What is the min Mileage you're looking for?");
        int min = scanner.nextInt();
        System.out.println("What is the max Mileage you're looking for?");
        int max = scanner.nextInt();
        dealership.byMileage(min,max);
    }
    public static void uiByType(Scanner scanner){
        System.out.println("What is the Vehicle Type are you looking for?");
        String type = scanner.nextLine();
        dealership.byType(type);
    }
// </editor-fold>
}
