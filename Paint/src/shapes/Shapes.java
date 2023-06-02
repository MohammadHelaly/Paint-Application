/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;

/**
 *
 * @author usefw
 */
public abstract class Shapes {
      private Color colour;
      int x1;
      int x2;
      int y1;
      int y2;
      int stroke;
      boolean isfilled;

    public Color getColor() {
        return colour;
    }

    public void setColor(Color c) {
        colour = c;
    }

    public Shapes(Color c) {
        colour = c;
    }
    public Shapes(int x1, int x2, int y1, int y2, Color color,int stroke,boolean isfilled) {
        colour=color;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.stroke=stroke;
        this.isfilled=isfilled;
    }

    public int getx1() {
        return x1;
    }

    public void setx1(int x1) {
        this.x1 = x1;
    }

    public int getx2() {
        return x2;
    }

    public void setx2(int x2) {
        this.x2 = x2;
    }

    public int gety1() {
        return y1;
    }

    public void sety1(int y1) {
        this.y1 = y1;
    }

    public int gety2() {
        return y2;
    }

    public void sety2(int y2) {
        this.y2 = y2;
    }
    
    public void setstroke(int stroke) {
        this.stroke = stroke;
    }

    public int getstroke() {
        return stroke;
    }
    
    public boolean isFilled() {
        return isfilled;
    }

    public void setfilled(boolean filled) {
        isfilled = filled;
    }
    
     public abstract boolean contains(int p1,int p2);
}
