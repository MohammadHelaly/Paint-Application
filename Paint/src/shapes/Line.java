/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.Graphics;

/**
 *
 * @author usefw
 */
public class Line extends Shapes{
   public Line(int x1,int x2,int y1,int y2,Color c){
  super(x1,x2,y1,y2,c);
  }

 /*   @Override
    public boolean contains(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    @Override
    public boolean contains(int p1, int p2) {
     
        float X1,X2,Y1,Y2,P1,P2;
        X1=x1;
        X2=x2;
        Y1=y1;
        Y2=y2;
        P1=p1;
        P2=p2;
        Float A,B;
       
        
                B=Math.abs((Y1-Y2)/(X2-X1));
           A=Math.abs((Y1-P2)/(X1-P1)); 
       //    System.out.println(A+" "+B);
         if((A/B)>0.95 &&(A/B)<1.05){
           return true;
           }
        
      return false;
    }
    
}
