package org.example;

import java.math.BigDecimal;

public class SalesContract extends Contract {
    //<editor-fold desc="Sales Contract Constructor">
    private BigDecimal taxAmount;
    private BigDecimal recordFee;
    private boolean finance;
    private BigDecimal processFee;
    private double monthlyPayment;


    public SalesContract(String dateOf, String customerName, String customerEmail, Vehicle vehicleSold, BigDecimal taxAmount, BigDecimal recordFee, boolean finance, BigDecimal processFee, double monthlyPayment) {
        super(dateOf, customerName, customerEmail, vehicleSold);
        this.taxAmount = taxAmount;
        this.recordFee = recordFee;
        this.finance = finance;
        this.processFee = processFee;
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getTaxAmount() {
        return BigDecimal.valueOf(getVehicleSold().getPrice()).multiply(BigDecimal.valueOf(0.05));
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

    public BigDecimal getProcessFee() {
        if (getVehicleSold().getPrice() < 10000) {
             processFee = BigDecimal.valueOf(295);
        }
        else {
            processFee = BigDecimal.valueOf(495);
        }
        return processFee;
    }

    public void setProcessFee(BigDecimal processFee) {
        this.processFee = processFee;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }


    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal price = BigDecimal.valueOf(getVehicleSold().getPrice());
        BigDecimal total = price.add(getProcessFee()).add(getTaxAmount()).add(getRecordFee());

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
        BigDecimal ten = BigDecimal.valueOf(10000);

        if (P.compareTo(ten) >= 0) {
            r = BigDecimal.valueOf(4.25 / 100);
            n = BigDecimal.valueOf(48);

            X = BigDecimal.ONE.add(r);//(1+r)
            T = (P.multiply(r).multiply(X.pow(n.intValue()))); //(p x r(1+r)n
            Y = BigDecimal.ONE.subtract(X);
            B = (P.multiply(Y.pow(n.intValue())));


            M = T.divide(B);
        } else {
            r = BigDecimal.valueOf(5.25 / 100);
            n = BigDecimal.valueOf(24);

            X = BigDecimal.ONE.add(r);
            T = (P.multiply(r).multiply(X.pow(n.intValue())));
            Y = BigDecimal.ONE.subtract(X);
            B = (P.multiply(Y.pow(n.intValue())));


            M = T.divide(B);
        }
        return M;
    }
    // </editor-fold>



}
