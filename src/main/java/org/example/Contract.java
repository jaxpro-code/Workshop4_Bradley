package org.example;

import java.math.BigDecimal;

public abstract class Contract{
    private String dateOf;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract(String dateOf, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.dateOf = dateOf;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDateOf() {
        return dateOf;
    }

    public void setDateOf(String dateOf) {
        this.dateOf = dateOf;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();



}
