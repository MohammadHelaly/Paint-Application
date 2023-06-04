/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;


//import  draw.CurrentShapes.drawings;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


import javax.swing.JPanel;
import shapes.Brush;
import shapes.Circle;
import shapes.Eraser;
import shapes.Line;
import shapes.OddShape;
import shapes.Rectangle;
import shapes.Shapes;
import shapes.Square;
import shapes.Triangle;
/**
 *
 * @author Helaly
 */
public class Board extends JPanel implements MouseListener, MouseMotionListener {
    
    Shapes resized=null;
    public static Dimension boarddims;
    public static Toolkit toolkit = Toolkit.getDefaultToolkit();
   static CurrentShapes c= CurrentShapes.Singleton();
        Color Colour = Color.BLACK;
    String shape="Brush";
          public static String redotype;
          public static int resize;
           Iterator <Shapes> it=CurrentShapes.drawings.iterator();
    public static Stack<Shapes> undo = new Stack<>();
    public static Stack<Shapes> redo = new Stack<>();
    public ArrayList<Point> points;
    public Point previousPoint;

           
    int stroke=1;
    boolean isfilled=false;

    int x1,x2,y1,y2,x3,y3;
    Boolean condition;
    int mode = -1;
    public static Shapes Lastl;
        public static Shapes  Lastr;
           public static  Shapes Lasts;
            public static Shapes Lastc;
            public static Shapes Lastt;
            public static Shapes Lasto;
            public static Shapes Lastb;
            public static Shapes Laste;            
    Shapes resizedshape=null;
    public  Board(){
        addMouseListener(this);
        addMouseMotionListener(this);   
    }
    public void paintComponent(Graphics draw){
      
        
        
        
        super.paintComponent(draw);
   //   int i=0;
      Shapes hold=null;
     Iterator <Shapes> it=CurrentShapes.drawings.iterator();
     while (it.hasNext()) {         
                    hold=it.next();

            if (/*c.drawings.get(i)*/hold instanceof Line ==true) {
                Line line = (Line) hold;
                draw.setColor(line.getColor());
                ((Graphics2D) draw).setStroke(new BasicStroke(line.getstroke()));
                draw.drawLine(line.getx1(), line.gety1(), line.getx2(), line.gety2());
            }
                else if(hold instanceof Brush){
                Brush b = (Brush) hold;
                draw.setColor(b.getColor());
                ((Graphics2D) draw).setStroke(new BasicStroke(b.getstroke()));
                b.xPositions.add(b.getx2());
                b.yPositions.add(b.gety2());        
                int arrayListSize = b.xPositions.size();
                int[] x = new int[arrayListSize];
                int[] y = new int[arrayListSize];
                for (int j = 0; j < arrayListSize; j++) {
                x[j] = b.xPositions.get(j);
                y[j] = b.yPositions.get(j);
                }
                    draw.drawPolyline(x, y, arrayListSize);
                }
                else if(hold instanceof Eraser){
                Eraser b = (Eraser) hold;
                draw.setColor(Color.WHITE);
                ((Graphics2D) draw).setStroke(new BasicStroke(b.getstroke()));
                b.xPositions.add(b.getx2());
                b.yPositions.add(b.gety2());        
                int arrayListSize = b.xPositions.size();
                int[] x = new int[arrayListSize];
                int[] y = new int[arrayListSize];
                for (int j = 0; j < arrayListSize; j++) {
                x[j] = b.xPositions.get(j);
                y[j] = b.yPositions.get(j);
                }
                    draw.drawPolyline(x, y, arrayListSize);
                }
            else if(hold instanceof Rectangle ){
                Rectangle r = (Rectangle) hold;
                draw.setColor(r.getColor());
                ((Graphics2D) draw).setStroke(new BasicStroke(r.getstroke()));
                if (r.isFilled()) {
                if (r.getx1()<r.getx2()&&r.gety1()<r.gety2()) {
                    draw.fillRect(r.getx1(), r.gety1(), r.getx2() - r.getx1(), r.gety2() - r.gety1());
                } else if (r.getx1() > r.getx2() && r.gety1() > r.gety2()) {
                    draw.fillRect(r.getx2(), r.gety2(), Math.abs(r.getx2() - r.getx1()), Math.abs(r.gety2() - r.gety1()));
                }
                else if (r.getx1()<r.getx2()&&r.gety1()>r.gety2()){
                    draw.fillRect(r.getx1(),r.gety2(),r.getx2()-r.getx1(),Math.abs(r.gety2()-r.gety1()));
                }
                else if (r.getx1()>r.getx2()&&r.gety1()<r.gety2()){
                    draw.fillRect(r.getx2(),r.gety1(),Math.abs(r.getx2()-r.getx1()),r.gety2()-r.gety1());
                }
                } else {            
                if (r.getx1()<r.getx2()&&r.gety1()<r.gety2()) {
                    draw.drawRect(r.getx1(), r.gety1(), r.getx2() - r.getx1(), r.gety2() - r.gety1());
                } else if (r.getx1() > r.getx2() && r.gety1() > r.gety2()) {
                    draw.drawRect(r.getx2(), r.gety2(), Math.abs(r.getx2() - r.getx1()), Math.abs(r.gety2() - r.gety1()));
                }
                else if (r.getx1()<r.getx2()&&r.gety1()>r.gety2()){
                    draw.drawRect(r.getx1(),r.gety2(),r.getx2()-r.getx1(),Math.abs(r.gety2()-r.gety1()));
                }
                else if (r.getx1()>r.getx2()&&r.gety1()<r.gety2()){
                    draw.drawRect(r.getx2(),r.gety1(),Math.abs(r.getx2()-r.getx1()),r.gety2()-r.gety1());
                }
                }
            }
            else if (hold instanceof Square){
                Square s = (Square) hold;
                draw.setColor(s.getColor());
                                ((Graphics2D) draw).setStroke(new BasicStroke(s.getstroke()));
            if(s.isFilled()){
                if (s.getx1()<s.getx2() && s.gety1()<s.gety2()){
                    draw.fillRect(s.getx1(),s.gety1(),s.getx2()-s.getx1()-1,s.getx2()-s.getx1()-1);
                }
                else if(s.getx1()> s.getx2() && s.gety1()>s.gety2()){
                    draw.fillRect(s.getx2(),s.gety2(),Math.abs(s.getx1()-s.getx2()),Math.abs(s.getx1()-s.getx2()));
               
                }

                else if(s.getx1()< s.getx2() && s.gety1()>s.gety2()){
                    draw.fillRect(s.getx1(),s.gety2(),Math.abs(s.gety2()-s.gety1()),Math.abs(s.gety2()-s.gety1()));
                }

                else if(s.getx1()> s.getx2() && s.gety1()<s.gety2()){
                    draw.fillRect(s.getx2(),s.gety1(),Math.abs(s.getx2()-s.getx1()),Math.abs(s.getx2()-s.getx1()));
                }                
            }else{
                if (s.getx1()<s.getx2() && s.gety1()<s.gety2()){
                    draw.drawRect(s.getx1(),s.gety1(),s.getx2()-s.getx1()-1,s.getx2()-s.getx1()-1);
                }
                else if(s.getx1()> s.getx2() && s.gety1()>s.gety2()){
                    draw.drawRect(s.getx2(),s.gety2(),Math.abs(s.getx1()-s.getx2()),Math.abs(s.getx1()-s.getx2()));
               
                }

                else if(s.getx1()< s.getx2() && s.gety1()>s.gety2()){
                    draw.drawRect(s.getx1(),s.gety2(),Math.abs(s.gety2()-s.gety1()),Math.abs(s.gety2()-s.gety1()));
                }

                else if(s.getx1()> s.getx2() && s.gety1()<s.gety2()){
                    draw.drawRect(s.getx2(),s.gety1(),Math.abs(s.getx2()-s.getx1()),Math.abs(s.getx2()-s.getx1()));
                }
            }
            }
            else if(hold instanceof Circle){
                Circle ci =(Circle) hold;
                draw.setColor(ci.getColor());
                                ((Graphics2D) draw).setStroke(new BasicStroke(ci.getstroke()));
            if(ci.isFilled()){
                                if (ci.getx1()<ci.getx2() && ci.gety1()<ci.gety2()){
                draw.fillOval(ci.getx1(),ci.gety1(),ci.getx2()-ci.getx1(),ci.getx2()-ci.getx1());
                }
                else if (ci.getx1() > ci.getx2() && ci.gety1() > ci.gety2()){
                    draw.fillOval(ci.getx2(),ci.gety2(),Math.abs(ci.getx2()-ci.getx1()),Math.abs(ci.getx2()-ci.getx1()));
                }
                else if (ci.getx1() < ci.getx2() && ci.gety1() > ci.gety2()){
                    draw.fillOval(ci.getx1(),ci.gety2(),Math.abs(ci.gety2()-ci.gety1()),Math.abs(ci.gety2()-ci.gety1()));
                }
                else if (ci.getx1() > ci.getx2() && ci.gety1() < ci.gety2()){
                    draw.fillOval(ci.getx2(),ci.gety1(),Math.abs(ci.getx2()-ci.getx1()),Math.abs(ci.getx2()-ci.getx1()));
                }
            }else{                
                if (ci.getx1()<ci.getx2() && ci.gety1()<ci.gety2()){
                draw.drawOval(ci.getx1(),ci.gety1(),ci.getx2()-ci.getx1(),ci.getx2()-ci.getx1());
                }
                else if (ci.getx1() > ci.getx2() && ci.gety1() > ci.gety2()){
                    draw.drawOval(ci.getx2(),ci.gety2(),Math.abs(ci.getx2()-ci.getx1()),Math.abs(ci.getx2()-ci.getx1()));
                }
                else if (ci.getx1() < ci.getx2() && ci.gety1() > ci.gety2()){
                    draw.drawOval(ci.getx1(),ci.gety2(),Math.abs(ci.gety2()-ci.gety1()),Math.abs(ci.gety2()-ci.gety1()));
                }
                else if (ci.getx1() > ci.getx2() && ci.gety1() < ci.gety2()){
                    draw.drawOval(ci.getx2(),ci.gety1(),Math.abs(ci.getx2()-ci.getx1()),Math.abs(ci.getx2()-ci.getx1()));
                }
               // draw.drawOval(x1, y1, WIDTH, HEIGHT);
            }    
            }
          
            else if (hold instanceof Triangle ){
                Triangle t=(Triangle)hold;
                draw.setColor(t.getColor());
                                ((Graphics2D) draw).setStroke(new BasicStroke(t.getstroke()));
                                
            if(t.isFilled()){ 
                int[] xPoints = {t.getx1(), t.getx1(), t.getx2()};
                int[] yPoints = {t.gety1(), t.gety2(), t.gety2()};
             draw.fillPolygon(xPoints,yPoints,3);
            }else{
                //draw.drawLine(t.getx1(),t.gety1(),t.getx1(),t.gety2());
                //draw.drawLine(t.getx1(),t.gety2(),t.getx2(),t.gety2());
                //draw.drawLine(t.getx1(),t.gety1(),t.getx2(),t.gety2());
                                int[] xPoints = {t.getx1(), t.getx1(), t.getx2()};
                int[] yPoints = {t.gety1(), t.gety2(), t.gety2()};
             draw.drawPolygon(xPoints,yPoints,3);
            }  
            }
            else if(hold instanceof OddShape){
                OddShape o=(OddShape)hold;
                
                draw.setColor(o.getColor());
                                ((Graphics2D) draw).setStroke(new BasicStroke(o.getstroke()));
                draw.drawLine(o.getx1(),o.gety1(),o.getx1(),o.gety2());
                draw.drawLine(o.getx1(),o.gety2(),o.getx2(),o.gety2());
                draw.drawLine(o.getx1(),o.gety1(),o.getx2(),o.gety2());
                draw.drawLine(o.getx1(),o.gety1(),o.getx2(),o.gety1());
                draw.drawLine(o.getx1(),o.gety2(),o.getx2(),o.gety1());
            }
       //     i++;
          //   it.next();
            }
     
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
        int i;
        //Colour= GUI_Draw.jColorChooser1.getColor();
        stroke= GUI_Draw.jSlider1.getValue();
        try{
            
            if(!shape.isEmpty() && ! shape.equals("resize") &&! shape.equals("move") &&! shape.equals("copy") &&! shape.equals("delete") &&! shape.equals("fill")){
            x1 = e.getX();
            y1 = e.getY();
            x2=e.getX();
            y2=e.getY();
      
            c.addshape(shape, x1, y1, x2, y2, Colour,stroke,isfilled); // (GetClassFactory.classgetter(shape,x1,y1,x2,y2,Colour));
            repaint();
            }
            
            if (shape.equals("copy"))
            {
                                        
                      x1 = e.getX();
        y1 = e.getY();
        x2=e.getX();
        y2=e.getY();
            for(i=c.drawings.size()-1 ;i>=0; i--){
             
            if(c.drawings.get(i).contains(x1, y1)){
             if(c.drawings.get(i) instanceof Rectangle){   
            resizedshape=(Rectangle)c.drawings.get(i);
            c.addshape("Rectangle", resizedshape.getx1(), resizedshape.gety1(), resizedshape.getx2(), resizedshape.gety2(), resizedshape.getColor(), resizedshape.getstroke(), resizedshape.isFilled());
            System.out.println("selected"+i);
            break;
            }
             
             else if(c.drawings.get(i) instanceof Square){
              resizedshape=(Square)c.drawings.get(i);
                          c.addshape("Square", resizedshape.getx1(), resizedshape.gety1(), resizedshape.getx2(), resizedshape.gety2(), resizedshape.getColor(), resizedshape.getstroke(), resizedshape.isFilled());
            System.out.println("selected"+i);
            break;
             }
              else if(c.drawings.get(i) instanceof Line){
              resizedshape=(Line)c.drawings.get(i);
            c.addshape("Line", resizedshape.getx1(), resizedshape.gety1(), resizedshape.getx2(), resizedshape.gety2(), resizedshape.getColor(), resizedshape.getstroke(), resizedshape.isFilled());              
            System.out.println("selected"+i);
            break;
             }
             else if(c.drawings.get(i) instanceof Circle){
              resizedshape=(Circle)c.drawings.get(i);
            c.addshape("Circle", resizedshape.getx1(), resizedshape.gety1(), resizedshape.getx2(), resizedshape.gety2(), resizedshape.getColor(), resizedshape.getstroke(), resizedshape.isFilled());             
            System.out.println("selected"+i);
            break;
             }
              else if(c.drawings.get(i) instanceof Triangle){
              resizedshape=(Triangle)c.drawings.get(i);
            c.addshape("Triangle", resizedshape.getx1(), resizedshape.gety1(), resizedshape.getx2(), resizedshape.gety2(), resizedshape.getColor(), resizedshape.getstroke(), resizedshape.isFilled());              
            System.out.println("selected"+i);
            break;
             }
             
             
            }
            }
                    }
         if (shape.equals("delete"))
            {
                                        
                      x1 = e.getX();
        y1 = e.getY();
        x2=e.getX();
        y2=e.getY();
            for(i=c.drawings.size()-1 ;i>=0; i--){
             
            if(c.drawings.get(i).contains(x1, y1)){
                c.drawings.remove(i);
                 repaint();
            }
            }
                    }
         if (shape.equals("fill")) {
             
                                                     
                      x1 = e.getX();
        y1 = e.getY();
        x2=e.getX();
        y2=e.getY();
            for(i=c.drawings.size()-1 ;i>=0; i--){
             
            if(c.drawings.get(i).contains(x1, y1)){
        c.drawings.get(i).setfilled(!c.drawings.get(i).isFilled());
        repaint();
            }
            }
             
 //   if (resizedshape != null) {
  //      resizedshape.setfilled(!resizedshape.isFilled());
   //     repaint();
   // }
}
            
            else{
                
                      x1 = e.getX();
        y1 = e.getY();
        x2=e.getX();
        y2=e.getY();
            for(i=c.drawings.size()-1 ;i>=0; i--){
             
            if(c.drawings.get(i).contains(x1, y1)){
             if(c.drawings.get(i) instanceof Rectangle){   
            resizedshape=(Rectangle)c.drawings.get(i);
            //c.addshape("Rectangle", resizedshape.getx1(), resizedshape.gety1(), resizedshape.getx2(), resizedshape.gety2(), resizedshape.getColor());
            System.out.println("selected"+i);
            break;
            }
             
             else if(c.drawings.get(i) instanceof Square){
              resizedshape=(Square)c.drawings.get(i);
            System.out.println("selected"+i);
            break;
             }
              else if(c.drawings.get(i) instanceof Line){
              resizedshape=(Line)c.drawings.get(i);
            System.out.println("selected"+i);
            break;
             }
             else if(c.drawings.get(i) instanceof Circle){
              resizedshape=(Circle)c.drawings.get(i);
            System.out.println("selected"+i);
            break;
             }
              else if(c.drawings.get(i) instanceof Triangle){
              resizedshape=(Triangle)c.drawings.get(i);
            System.out.println("selected"+i);
            break;
             }
             
             
            }
            }
            }
          
           
        }catch(Exception ex){
            
        }
       
    }
   
    
        public void undo() {
      
        //if (!undo.isEmpty()){
        try{

             // if (!undo.isEmpty()){
                       if(!c.drawings.isEmpty()){
            redo.push(c.drawings.get(c.drawings.size()-1));

            c.removeshape();
            repaint();
        }
         //  repaint();
                    }catch(Exception ex){
            
        }
       // }
    }
    
        public void redo() {
        try{    

        if (!redo.isEmpty()) {

            c.drawings.add(redo.pop());
            undo.push(c.drawings.get(c.drawings.size()-1));
            repaint();
        }
                           }catch(Exception ex){
            
        }
    }
        
        
           public void clearAllShapes()
    {
                   c.drawings.clear();
                   repaint();
    }
    
   /* 
    public void redo(){
        try{
    if(redotype.equals("Line")){
    c.drawings.add(Lastl);
    repaint();
    }
     if(redotype.equals("Square")){
    c.drawings.add(Lasts);
    repaint();
    } if(redotype.equals("Rectangle")){
    c.drawings.add(Lastr);
    repaint();
    } if(redotype.equals("Circle")){
    c.drawings.add(Lastc);
    repaint();
    } if(redotype.equals("Triangle")){
    c.drawings.add(Lastt);
    repaint();
    }
    if(redotype.equals("Brush")){
    c.drawings.add(Lastb);
    repaint();
    } if(redotype.equals("Eraser")){
    c.drawings.add(Laste);
    repaint();
    }    
    if(redotype.equals("OddShape")){
    c.drawings.add(Lasto);
    repaint();
    }
        }catch(Exception ex) {
            
            }
    }*/

 
       

  


    @Override
    public void mouseReleased(MouseEvent e) {
                   //     previousPoint = null;
                //points.clear();
                //repaint();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        try{  
        
     if (shape.equals("Line")) {
            x2 = e.getX();
            y2 = e.getY();
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof Line) {
                Line l = (Line) shape;
                l.setx2(x2);
                l.sety2(y2);
            }

            repaint();
            condition = false;
        } 
          else if (shape.equals("Rectangle")) {
            
              
              x2 = e.getX();
            y2 = e.getY();
         
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                rectangle.setx2(x2);
                rectangle.sety2(y2);
            }

            repaint();
            condition=false;
        }
                else if (shape.equals("Brush")) {
            x2 = e.getX();
            y2 = e.getY();
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof Brush) {
                Brush brush = (Brush) shape;
                brush.setx2(x2);
                brush.sety2(y2);
            }
            repaint();
            condition=false;
        }   
        else if (shape.equals("Eraser")) {
            x2 = e.getX();
            y2 = e.getY();
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof Eraser) {
                Eraser eraser = (Eraser) shape;
                //eraser.xPositions.add(x2);
                //eraser.yPositions.add(y2);
                eraser.setx2(x2);
                eraser.sety2(y2);
            }
            repaint();
            condition=false;
        }  
          
          else if (shape.equals("Square")){
              x2 = e.getX();
            y2 = e.getY();
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof Square) {
                Square ss = (Square) shape;
                ss.setx2(x2);
                ss.sety2(y2);
            }

            repaint();
            condition = false;
          }
          else if(shape.equals("Circle")){
              x2 = e.getX();
            y2 = e.getY();
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                c.setx2(x2);
                c.sety2(y2);
            }

            repaint();
            condition = false;
          }
          else if (shape.equals("Triangle")){
              x3 = e.getX();
            y3 = e.getY();
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof Triangle) {
                Triangle t = (Triangle) shape;
                t.setx2(x3);
                t.sety2(y3);
            }

            repaint();
            condition = false;
          }
        else if (shape.equals("OddShape")){
              x3 = e.getX();
            y3 = e.getY();
            Shapes shape = c.drawings.get(c.drawings.size() - 1);
            if (shape instanceof OddShape) {
                OddShape o = (OddShape) shape;
                o.setx2(x3);
                o.sety2(y3);
            }

            repaint();
            condition = false;
          }
        
     else if(shape.equals("resize")){
            
        if(resizedshape!=null){
            
        if(resizedshape instanceof Rectangle){
               x2 = e.getX();
            y2 = e.getY();
        Rectangle rectangle=(Rectangle)resizedshape;
        rectangle.setx1(rectangle.getx1()+x1-x2);
       
         rectangle.sety1(rectangle.gety1()+y1-y2);
        y1=y2;
        x1=x2;
        repaint();
        }       
        if(resizedshape instanceof Square){
               x2 = e.getX();
            y2 = e.getY();
        Square sq=(Square)resizedshape;
        sq.setx1(sq.getx1()+x1-x2);
       
        // sq.sety1(sq.gety1()+y1-y2);
      //  y1=y2;
        x1=x2;

        repaint();
        }
         if(resizedshape instanceof Line){
               x2 = e.getX();
            y2 = e.getY();
        Line sq=(Line)resizedshape;
        sq.setx2(sq.getx2()+x1-x2);
       
         sq.sety2(sq.gety2()+y1-y2);
        y1=y2;
        x1=x2;

        repaint();
        }
         if(resizedshape instanceof Circle){
               x2 = e.getX();
            y2 = e.getY();
        Circle sq=(Circle)resizedshape;
        sq.setx2(sq.getx2()+x1-x2);
       
         sq.sety2(sq.gety2()+y1-y2);
        y1=y2;
        x1=x2;

        repaint();
        }
          if(resizedshape instanceof Triangle){
               x2 = e.getX();
            y2 = e.getY();
        Triangle sq=(Triangle)resizedshape;
        sq.setx2(sq.getx2()+x1-x2);
       
         sq.sety2(sq.gety2()+y1-y2);
        y1=y2;
        x1=x2;

        repaint();
        }

        
        
        }
        }
        else if(shape.equals("move") || shape.equals("copy")){
            
        if(resizedshape!=null){
            
if (resizedshape instanceof Rectangle) {
    x2 = e.getX();
    y2 = e.getY();
    Rectangle rectangle = (Rectangle) resizedshape;
    int dx = x2 - x1; // Calculate the difference in x-coordinates
    int dy = y2 - y1; // Calculate the difference in y-coordinates
    //c.addshape("Line", x1, y1, x2, y2, Colour,stroke,isfilled);
    rectangle.setx1(rectangle.getx1() + dx); // Update the x-coordinate of the top-left corner
    rectangle.setx2(rectangle.getx2() + dx); // Update the x-coordinate of the bottom-right corner
    rectangle.sety1(rectangle.gety1() + dy); // Update the y-coordinate of the top-left corner
    rectangle.sety2(rectangle.gety2() + dy); // Update the y-coordinate of the bottom-right corner
    x1 = x2; // Update the previous mouse x-coordinate
    y1 = y2; // Update the previous mouse y-coordinate
    repaint();
}

if (resizedshape instanceof Square) {
    x2 = e.getX();
    y2 = e.getY();
    Square square = (Square) resizedshape;
    //c.addshape("Square", x1, y1, x2, y2, Colour);
    int dx = x2 - x1; // Calculate the difference in x-coordinates
    int dy = y2 - y1; // Calculate the difference in y-coordinates
    square.setx1(square.getx1() + dx); // Update the x-coordinate of the top-left corner
    square.setx2(square.getx2() + dx); // Update the x-coordinate of the bottom-right corner
    square.sety1(square.gety1() + dy); // Update the y-coordinate of the top-left corner
    square.sety2(square.gety2() + dy); // Update the y-coordinate of the bottom-right corner
    x1 = x2; // Update the previous mouse x-coordinate
    y1 = y2; // Update the previous mouse y-coordinate
    repaint();
}

if (resizedshape instanceof Line) {
    x2 = e.getX();
    y2 = e.getY();
    Line line = (Line) resizedshape;
    int dx = x2 - x1; // Calculate the difference in x-coordinates
    int dy = y2 - y1; // Calculate the difference in y-coordinates
    line.setx1(line.getx1() + dx); // Update the x-coordinate of the line's start point
    line.sety1(line.gety1() + dy); // Update the y-coordinate of the line's start point
    line.setx2(line.getx2() + dx); // Update the x-coordinate of the line's end point
    line.sety2(line.gety2() + dy); // Update the y-coordinate of the line's end point
    x1 = x2; // Update the previous mouse x-coordinate
    y1 = y2; // Update the previous mouse y-coordinate
        repaint();
        }
         if(resizedshape instanceof Circle){
               x2 = e.getX();
            y2 = e.getY();
        Circle circle=(Circle)resizedshape;
    int dx = x2 - x1; // Calculate the difference in x-coordinates
    int dy = y2 - y1; // Calculate the difference in y-coordinates
    circle.setx1(circle.getx1() + dx); // Update the x-coordinate of the top-left corner
    circle.setx2(circle.getx2() + dx); // Update the x-coordinate of the bottom-right corner
    circle.sety1(circle.gety1() + dy); // Update the y-coordinate of the top-left corner
    circle.sety2(circle.gety2() + dy); // Update the y-coordinate of the bottom-right corner
    x1 = x2; // Update the previous mouse x-coordinate
    y1 = y2; // Update the previous mouse y-coordinate
    repaint();
        }
          if(resizedshape instanceof Triangle){
               x2 = e.getX();
            y2 = e.getY();
        Triangle sq=(Triangle)resizedshape;
    int dx = x2 - x1; // Calculate the difference in x-coordinates
    int dy = y2 - y1; // Calculate the difference in y-coordinates
    sq.setx1(sq.getx1() + dx); // Update the x-coordinate of the top-left corner
    sq.setx2(sq.getx2() + dx); // Update the x-coordinate of the bottom-right corner
    sq.sety1(sq.gety1() + dy); // Update the y-coordinate of the top-left corner
    sq.sety2(sq.gety2() + dy); // Update the y-coordinate of the bottom-right corner
    x1 = x2; // Update the previous mouse x-coordinate
    y1 = y2; // Update the previous mouse y-coordinate
    repaint();
        }

        
        
        }
        }
     
     
    else if(shape.equals("brush")){
            
    x2 = e.getX();
    y2 = e.getY();
    int dx = x2 - x1; // Calculate the difference in x-coordinates
    int dy = y2 - y1; // Calculate the difference in y-coordinates
    c.addshape("Line", x1, y1, x2, y2, Colour,stroke,isfilled);
    x1 = x2; // Update the previous mouse x-coordinate
    y1 = y2; // Update the previous mouse y-coordinate
    repaint();
    
        }
        else if(shape.equals("eraser")){
            
    x2 = e.getX();
    y2 = e.getY();
    int dx = x2 - x1; // Calculate the difference in x-coordinates
    int dy = y2 - y1; // Calculate the difference in y-coordinates
    c.addshape("Line", x1, y1, x2, y2, Color.WHITE,stroke,isfilled);
    x1 = x2; // Update the previous mouse x-coordinate
    y1 = y2; // Update the previous mouse y-coordinate
    repaint();
    
        } 
     
         condition = false;
        
         
         
        }catch(Exception ex){
            
        }
        
          
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
