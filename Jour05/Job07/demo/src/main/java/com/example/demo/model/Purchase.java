package com.example.demo.model;

import java.io.Serializable;

public class Purchase implements Serializable {

    private String product;
    private String customerName;
    private String email;

    // Constructeur par défaut
    public Purchase() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
