package org.example;

import java.math.BigDecimal;
import org.example.Vehicle.*;
import org.example.Dealership.*;
import org.w3c.dom.ls.LSOutput;

public class SalesContract extends Contract {
    //<editor-fold desc="Sales Contract Constructor">
    private Dealership dealership;
    private BigDecimal taxAmount;
    private BigDecimal recordFee;
    private boolean finance;
    private BigDecimal processFee;
    private double monthlyPayment;
    private Vehicle vehicleSold;

    public SalesContract(String dateOf, String customerName, String customerEmail, BigDecimal taxAmount, BigDecimal recordFee, boolean finance, BigDecimal processFee, double monthlyPayment, Vehicle vehicleSold) {
        super(dateOf, customerName, customerEmail);
        this.taxAmount = taxAmount;
        this.recordFee = recordFee;
        this.finance = finance;
        this.processFee = processFee;
        this.monthlyPayment = monthlyPayment;
        this.vehicleSold = vehicleSold;
    }

    public BigDecimal getTaxAmount() {
        return BigDecimal.valueOf(0.05);
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getRecordFee() {
        return BigDecimal.valueOf(100);
    }

    public void setRecordFee(BigDecimal recordFee) {
        this.recordFee = recordFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public void getProcessFee(int vin) {
        for(Vehicle v: dealership.getAllVehicles()) {
            if(v.getVin() == vin){
                if (v.getPrice() < 10000) {
                    BigDecimal processFee = BigDecimal.valueOf(295);
                } else {
                    BigDecimal processFee = BigDecimal.valueOf(495);
                }
            }
        }
    }

    public void setProcessFee(BigDecimal processFee) {
        this.processFee = processFee;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    @Override
    public void getMonthlyPayment() {
        BigDecimal P;
        BigDecimal M;
        BigDecimal T;
        BigDecimal B;
        BigDecimal X;
        BigDecimal Y;
        BigDecimal r = BigDecimal.valueOf(4.25/100);
        BigDecimal n = BigDecimal.valueOf(48);
        for(Vehicle v : dealership.getAllVehicles()){
            if(isFinance()){
                if(v.getPrice() >= 10000){
                    P = BigDecimal.valueOf(v.getPrice());
//                    M = BigDecimal.valueOf((P * r) / ( 1 - Math.pow((1 + r), -n)));
//                    M = P.multiply(r) / (1 - Math.pow((r.add(BigDecimal.valueOf(1)),n.negate()));
                    X = BigDecimal.ONE.add(r);
                    T = (P.multiply(r).multiply(X.pow(n.intValue())));
                    Y= (X.pow(n.intValue()));
                    B = BigDecimal.ONE.subtract(Y);

                    M = T.divide(B);

                    System.out.println(M);
                }
            }
        }
    }

    @Override
    public void getTotalPrice() {

    }

// </editor-fold>









}
