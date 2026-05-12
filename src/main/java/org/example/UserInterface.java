package org.example;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;
    //the menus and the confirmations
    //to strings - vin|year|make|modle|type|color|odometer|price
    //while loop

//<editor-fold desc="ui">
    public UserInterface(){
        this.scanner = new Scanner(System.in);
        init();
    }
    private void init(){
        // when u call a class you are creating a label
        // in it is a method that fills the method with data
        // when u write private you are declaring it -- this just say i will have a dealership object in here but it is null rn.
        // init - intialize start the file manager and reads the cvs and constructs the objects
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void Display(){
        init();
        boolean run = true;
        while(run){
           display();
           String uI = scanner.nextLine();

           switch(uI){
               case "1":
                 processAllVehicleRequest();
                 break;
               case "2":
                   processAddVehicleRequest();
                   break;
               case "3":
                   processByPriceRequest();
                   break;
               case "4":
                   processByMakeModelRequest();
                   break;
               case "5":
                   processByYearRequest();
                   break;
               case "6":
                   processByMileageRequest();
                   break;
               case "7":
                   processByTypeRequest();
                   break;
               case "8":
                   processByColorRequest();
                   break;
               case "9":
                   processRemoveVehicleRequest();
                   break;
               default:
                   System.out.println("Please make a selection 1-9");
           }
        }
    }
    // </editor-fold>

//<editor-fold desc="UserInterface Methods">
    public void display(){
        System.out.println("1) List All Vehicles"+
                "\n2) Add a Vehicle"+
                "\n3) Find Vehicle by Price " +
                "\n4) Find Vehicle by Make and Model"+
                "\n5) Find Vehicle by Year"+
                "\n6) Find Vehicle by Mileage"+
                "\n7) Find Vehicle by Vehicle Type"+
                "\n8) Find Vehicle by Color"+
                "\n9) Remove Vehicle from Dealership");
    }
    public void processAddVehicleRequest(){
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
        DealershipFileManager.writeDealership(dealership);
        System.out.println("The Vehicle has been added to the Inventory");
    }
    public void processRemoveVehicleRequest(){
        System.out.println("Which Vehicle would you like to Remove"+
                "Enter the Vin");
        int vin = scanner.nextInt();
        dealership.removeVehicles(vin);
        System.out.println("The Vehicle has been removed from the Inventory");
    }
    public void processAllVehicleRequest(){
        System.out.println("Painter Garage|1002 Main Street|803-209-6747\n");
        for(Vehicle V : dealership.getAllVehicles()){
            System.out.println(V.toString());
        }
    }
    public void processByPriceRequest(){
        System.out.println("What is the Min of the Vehicle Price Range?");
        double min = scanner.nextDouble();
        System.out.println("What is the Max of the Vehicle Price Range?");
        double max = scanner.nextDouble();
        dealership.byPrice(min,max);
    }
    public void processByMakeModelRequest(){
        System.out.println("What is the Make of the Vehicle you're looking for?");
        String make = scanner.nextLine();
        System.out.println("What is the Model of the Vehicle you're looking for?");
        String model = scanner.nextLine();
        dealership.byMakeModel(make,model);
    }
    public void processByYearRequest(){
        System.out.println("What is the min Year of the Vehicle you're looking for?");
        int min = scanner.nextInt();
        System.out.println("What is the max Year of the Vehicle you're looking for? ");
        int max = scanner.nextInt();
        dealership.byYear(min,max);
    }
    public void processByColorRequest(){
        System.out.println("What is the color of Vehicle you're looking for?");
        String color = scanner.nextLine();
        dealership.byColor(color);
    }
    public void processByMileageRequest(){
        System.out.println("What is the min Mileage you're looking for?");
        int min = scanner.nextInt();
        System.out.println("What is the max Mileage you're looking for?");
        int max = scanner.nextInt();
        dealership.byMileage(min,max);
    }
    public void processByTypeRequest(){
        System.out.println("What is the Vehicle Type are you looking for?");
        String type = scanner.nextLine();
        dealership.byType(type);
    }
// </editor-fold>
}
