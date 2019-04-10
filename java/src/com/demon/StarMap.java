package com.demon;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet{

    ArrayList<Star> stars = new ArrayList<Star>();
    public float border = 50;

    public void settings(){
        size(800, 800);
        loadDataSet();
        printStars();
    }

    public void loadDataSet(){
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow row:table.rows()){
            stars.add(new Star(row));       
        }
    }

    public void printStars(){
        for(Star star:stars){
            System.out.println(star);
        }
    }

    public void printGrid(){
        fill(138,43,226);
        stroke(138,43,226);
        textAlign(CENTER, CENTER);
        for(float x = -5; x <= 5; x++){
            float lineX = map(x, -5, 5, border, height - border);
            line(lineX, border, lineX, height - border);
            text((int) x, lineX, (height * 0.0125f)); 
        }
        
        for(float y = -5; y <= 5; y++){
            float lineY = map(y, -5, 5, border, width - border);
            line(border, lineY, width - border, lineY);
            text((int) y, (width * 0.0125f), lineY);
        }
    }

    public void drawStars(){
        noFill();
        for(Star star:stars)
        {
            float x = star.screenPos.x;
            float y = star.screenPos.y;  
            stroke(255, 255, 0);
            line(x-2, y, x+2, y);
            line(x, y - 2, x, y + 2);    
            stroke(255, 0, 0);  
            noFill();
            ellipse(x, y, star.magnitude, star.magnitude);
            
            textAlign(LEFT, CENTER);
            fill(255);
            text(star.displayName, x + 10, y - 2);
            
        } 
    }

    public void draw(){
        background(0);
        printGrid();
        drawStars();
    }

    

}