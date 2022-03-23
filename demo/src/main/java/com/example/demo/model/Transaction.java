package com.example.demo.model;

import java.io.Serializable;

public class Transaction implements Serializable {
    private  Long transaction_id ;
    private  double amount;
    private  String type;
    private  Long parent_id;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
