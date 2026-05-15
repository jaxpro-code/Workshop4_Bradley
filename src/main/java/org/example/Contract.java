package org.example;

public abstract class Contract{
    private String dateOf;
    private String customerName;
    private String customerEmail;

    public Contract(String dateOf, String customerName, String customerEmail) {
        this.dateOf = dateOf;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
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

    public abstract void getTotalPrice();

    public abstract void getMonthlyPayment();



}
