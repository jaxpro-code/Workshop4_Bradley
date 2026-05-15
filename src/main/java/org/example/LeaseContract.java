package org.example;

import java.math.BigDecimal;

public class LeaseContract extends Contract {

    public LeaseContract(String dateOf, String customerName, String customerEmail) {
        super(dateOf, customerName, customerEmail);
    }

    @Override
    public void getTotalPrice() {

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
}
