package com.demon; /// Jason van Raamsdonk

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class CafeRubis extends PApplet{

    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Product> bill = new ArrayList<Product>();

    public void settings(){
        size(800, 600);
        loadDataSet();
    }

    public void loadDataSet(){
        Table table = loadTable("cafe.csv", "header");

        for(TableRow row:table.rows()){
            products.add(new Product(row));
        }
    }

    public void printArrayList(){

        float border = height * 0.1f;
        float start = width * 0.05f;
        float w = width * 0.4f;
        float h = height * 0.1f;

        textSize(16);
        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            float y = map(i, 0, products.size(), border, height);
            fill(255);
            rect(start, y - 20, w, h, 7);
            fill(0);
            textAlign(LEFT, CENTER);
            text(p.name, start + 10, y);
            textAlign(LEFT, CENTER);
            text(nf(p.price), start + (w - border), y);

        }

    }

    public void mousePressed(){
        float border = height * 0.1f;
        float start = width * 0.05f;
        float w = width * 0.4f;
        float h = height * 0.1f;

        for(int i = 0; i < products.size(); i++){
            float y = map(i, 0, products.size(), border, height);
            if((mouseX > start && mouseX < start + w) && (mouseY > y && mouseY < y + h)){
                bill.add(products.get(i));
                Product p = products.get(i);
                System.out.println(p.name + " " + p.price);
            }
        }
    }

    public void drawBill(){
        float border = height * 0.07f;
        float start = width * (0.6f);
        float w = width * 0.35f;
        float h = height * 0.87f;

        stroke(0);
        fill(255);
        rect(start, border, w, h, 7);
        fill(0);
        textAlign(CENTER, CENTER);
        text("Your Bill:", (float) width * 0.77f, border * 1.3f);

        float total = 0;
        float y = border + 50;
        float x = start + 50;
        float gap = 30;
        for(int i = 0; i < bill.size(); i++){
            Product b = bill.get(i);
            textAlign(LEFT, CENTER);
            text(b.name, start + 10, y);
            textAlign(RIGHT, CENTER);
            text(nf(b.price), start + w - 10, y);
            y += gap;
            total += b.price;
        }
        textAlign(LEFT, CENTER);
        text("Total:", start + 10, y);
        textAlign(RIGHT, CENTER);
        text(nf(total, 0, 2), start + w - 10, y);

    }

    public void draw(){

        printArrayList();
        drawBill();
    }
}