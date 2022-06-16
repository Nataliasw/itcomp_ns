package com.company;

public class Customer {



    private final String customerType;
    public String customerName;


    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;

    }
    public String getCustomerType() {
        return customerType;
    }


}
