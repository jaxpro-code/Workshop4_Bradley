package org.example;

import java.math.BigDecimal;

public class LeaseContract extends Contract {
    private BigDecimal endingValue;
    private BigDecimal leaseFee;

    public LeaseContract(String dateOf, String customerName, String customerEmail, Vehicle vehicleSold, BigDecimal endingValue, BigDecimal leaseFee) {
        super(dateOf, customerName, customerEmail, vehicleSold);
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    public BigDecimal getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(BigDecimal endingValue) {
        this.endingValue = endingValue;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal price = BigDecimal.valueOf(getVehicleSold().getPrice());
        BigDecimal total = price.add(leaseFee);

        return total;
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
        Y = (X.pow(n.intValue()));
        B = BigDecimal.ONE.subtract(Y);

        M = T.divide(B);


        return M;
    }


}