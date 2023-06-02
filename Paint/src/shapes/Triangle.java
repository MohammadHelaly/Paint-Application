/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;

/**
 *
 * @author ACERPC
 */
public class Triangle extends Shapes {
  public Triangle(int x1,int x2,int y1,int y2,Color c,int stroke,boolean isfilled){
  super(x1,x2,y1,y2,c,stroke,isfilled);
  }

 //   @Override
   // public boolean contains(int x, int y) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    @Override
    public boolean contains(int p1, int p2) {
      //  System.out.println(x1+" "+x2);
     //   System.out.println(y1+" "+y2);
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
         
   
        
        /*     if(x2>x1 && y2<y1){
            if(p1>x1 && p1<x2 && p2<y1 && p2>y2)
        return true;
        }
        
      */  
        
        return false;
        
       //To change body of generated methods, choose Tools | Templates.
    /*   java.awt.Rectangle r = new java.awt.Rectangle(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
            if(r.contains(p1,p2))
                return true;
            r = new java.awt.Rectangle(x2,y1,Math.abs(x2-x1),Math.abs(y2-y1));
            if(r.contains(p1,p2))
                return true;
            r= new java.awt.Rectangle(x2,y2,Math.abs(x2-x1),Math.abs(y2-y1));
            if(r.contains(p1,p2))
                return true;
            r=new java.awt.Rectangle(x1,y2,Math.abs(x2-x1),Math.abs(y2-y1));
            if(r.contains(p1,p2))
                return true;
     return false;
*/
    }
   
    
}
