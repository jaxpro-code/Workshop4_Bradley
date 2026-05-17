package org.example;

import java.io.*;

public class ContractFileManager {
    public static void saveContract (Contract contract){
        try {
            File file = new File("src/main/resources/Contract.csv");
            FileWriter fileWriter = new FileWriter(file, true);
            String DATA = "";

            if(contract instanceof SalesContract){
                SalesContract C = (SalesContract) contract;

                DATA = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%b|%.2f\n", C.getDateOf(), C.getCustomerName(), C.getCustomerEmail(), C.getVehicleSold().getVin(), C.getVehicleSold().getYear(), C.getVehicleSold().getMake(), C.getVehicleSold().getModel(),
                        C.getVehicleSold().getType(), C.getVehicleSold().getColor(), C.getVehicleSold().getOdometer(), C.getVehicleSold().getPrice(), C.getTaxAmount(), C.getRecordFee(), C.getProcessFee(), C.getTotalPrice(), C.isFinance(), C.getMonthlyPayment());
            }

            else if(contract instanceof LeaseContract){
                LeaseContract S = (LeaseContract) contract;

                DATA = String.format("LEASE|%s|%s|%s|%s|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f\n", S.getDateOf(), S.getCustomerName(), S.getCustomerEmail(), S.getVehicleSold().getVin(), S.getVehicleSold().getYear(), S.getVehicleSold().getMake(), S.getVehicleSold().getModel(),
                        S.getVehicleSold().getType(), S.getVehicleSold().getColor(), S.getVehicleSold().getOdometer(), S.getVehicleSold().getPrice(), S.getEndingValue(), S.getLeaseFee(), S.getTotalPrice(), S.getMonthlyPayment());
            }

            fileWriter.write(DATA);
        }
        catch (IOException ex){
            System.out.println("error writing to file");
        }
    }
}
