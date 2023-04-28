/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import java.awt.Color;
import java.util.ArrayList;
import shapes.GetClassFactory;
import shapes.Shapes;

/**
 *
 * @author usefw
 */
public  class CurrentShapes implements Subject{
    static   ArrayList<Shapes> drawings = new ArrayList<Shapes>();
            static CurrentShapes s=new CurrentShapes();
             private CurrentShapes(){
             
             }
             public static CurrentShapes Singleton(){
             if(s==null)
              s=new CurrentShapes();   
             
             return s;
             
             }
    public void  addshape(String shape,int x1,int y1,int x2,int y2,Color Colour){
   drawings.add(GetClassFactory.classgetter(shape,x1,x2,y1,y2,Colour));
   
}
     public  void removeshape(){
     drawings.remove(drawings.size()-1);
     }

   
   


    

   
}
