package com.demon;

import processing.core.PVector;
import processing.data.TableRow;

public class Star extends StarMap{
    public String displayName;
    public float distance;
    public float magnitude;
    public boolean habitable;
    public PVector pos;
    public PVector screenPos;

    private float height = 800;
    private float width = 800;

    public Star(TableRow row) {
        this.displayName = row.getString("Display Name");
        this.distance = row.getFloat("Distance");
        this.magnitude = row.getFloat("AbsMag");
        this.habitable = (row.getInt("Hab?") == 1);
        this.pos = new PVector(
                row.getFloat("Xg"),
                row.getFloat("Yg"),
                row.getFloat("Zg")
                                );
        this.screenPos = new PVector(
                map(pos.x, -5, 5, border, width - border),
                map(pos.y, -5, 5, border, height - border));
    }

    @Override
    public String toString() {
        return "{" +
            " displayName='" + displayName + "'" +
            ", distance='" + distance + "'" +
            ", magnitude='" + magnitude + "'" +
            ", habitable='" + habitable + "'" +
            ", pos='" + pos + "'" +
            ", screenPos='" + screenPos + "'" +
            "}";
    }
}