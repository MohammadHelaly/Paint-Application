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
public class GetClassFactory {
    public static Shapes classgetter(String type,int x1,int x2,int y1,int y2,Color c,int stroke,boolean isfilled){
    
        if(type.equals("Line")){
    return new Line(x1,x2,y1,y2,c,stroke,isfilled);
    }
        else if(type.equals("Rectangle")){
    return new Rectangle(x1,x2,y1,y2,c,stroke,isfilled);
    }
        else if(type.equals("Square")){
    return new Square(x1,x2,y1,y2,c,stroke,isfilled);
    }
        else if(type.equals("Circle")){
    return new Circle(x1,x2,y1,y2,c,stroke,isfilled);
    }
    else if(type.equals("Triangle")) {
        return new Triangle(x1,x2,y1,y2,c,stroke,isfilled);
    }
    else if(type.equals("Eraser")) {
        return new Eraser(x1,x2,y1,y2,c,stroke,isfilled);
    }
    else if(type.equals("Brush")) {
        return new Brush(x1,x2,y1,y2,c,stroke,isfilled);
    }  
    else{
    
        return new OddShape(x1,x2,y1,y2,c,stroke,isfilled);
    }
    }
}
