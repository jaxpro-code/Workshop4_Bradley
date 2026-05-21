package org.example;

import java.math.BigDecimal;

public class LeaseContract extends Contract {
    private BigDecimal endingValue;
    private BigDecimal leaseFee;
    private BigDecimal monthlyPayment;

    public LeaseContract(String dateOf, String customerName, String customerEmail, Vehicle vehicleSold, BigDecimal endingValue, BigDecimal leaseFee) {
        super(dateOf, customerName, customerEmail, vehicleSold);
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getLeaseFee() {
        return BigDecimal.valueOf(getVehicleSold().getPrice()).multiply(BigDecimal.valueOf(0.07));
    }


    public BigDecimal getEndingValue() {
        return BigDecimal.valueOf(getVehicleSold().getPrice()).multiply(BigDecimal.valueOf(0.50));
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal price = getEndingValue().add(getLeaseFee());


        return price;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal P;
        BigDecimal M;
        BigDecimal T;
        BigDecimal B;
        BigDecimal X;
        BigDecimal Y;
        BigDecimal r;
        BigDecimal n;
        P = BigDecimal.valueOf(getVehicleSold().getPrice());
        r = BigDecimal.valueOf(4.00 / 100);
        n = BigDecimal.valueOf(36);

        X = BigDecimal.ONE.add(r);
        T = (P.multiply(r).multiply(X.pow(n.intValue())));
        Y = BigDecimal.ONE.subtract(X);
        B = (P.multiply(Y.pow(n.intValue())));


        M = T.divide(B);

        return M;
    }


}