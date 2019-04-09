package com.demon;

import processing.data.*;

public class Product{

    String name;
    float price;

    public Product(TableRow row) {
        this.name = row.getString("Name");
        this.price = row.getFloat("Price");
    }

} 