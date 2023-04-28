/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.Graphics;
import java.awt.Point;
//import java.awt.Point;

/**
 *
 * @author usefw
 */
public class Rectangle extends Shapes{
    public Rectangle(int x1,int x2,int y1,int y2,Color c){
  super(x1,x2,y1,y2,c);
  }

    @Override
    public boolean contains(int p1, int p2) {
        
        
         if(x2>x1 && y2<y1){
            if(p1>x1 && p1<x2 && p2<y1 && p2>y2)
        return true;
            else return false;
        }
         if(x1>x2 && y2<y1){
            if(p1>x2 && p1<x1 && p2<y1 && p2>y2)
        return true;
            else return false;
        }
          if(x2>x1 && y1<y2){
            if(p1>x1 && p1<x2 && p2<y2 && p2>y1)
        return true;
            else return false;
        }
           if(x1>x2 && y1<y2){
            if(p1>x2 && p1<x1 && p2<y2 && p2>y1)
        return true;
            else return false;
           }
           return false;
    /*   java.awt.Rectangle rect1 = new java.awt.Rectangle(this.x1, this.y1, Math.abs(this.x1 - this.x2),Math.abs(this.y2 - this.y1));
         java.awt.Rectangle rect2 = new java.awt.Rectangle(this.x1, this.y2, Math.abs(this.x1 - this.x2),Math.abs(this.y2 - this.y1));
          java.awt.Rectangle rect3 = new java.awt.Rectangle(this.x2, this.y1, Math.abs(this.x1 - this.x2),Math.abs(this.y2 - this.y1));
           java.awt.Rectangle rect4 = new java.awt.Rectangle(this.x2, this.y2, Math.abs(this.x1 - this.x2),Math.abs(this.y2 - this.y1));
           
           
        if (rect1.contains(p1, p2)) {
            return true;
            
        } 
        else if (rect2.contains(p1, p2)) {
            return true;
            
        } 
         else if (rect3.contains(p1, p2)) {
            return true;
            
        } 
          else if (rect4.contains(p1, p2)) {
            return true;
            
        } 
        else {
            return false;
        }
*/
      
        
    
       
    }
    
}
