/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;


//import  draw.CurrentShapes.drawings;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;


import javax.swing.JPanel;
import shapes.Circle;
import shapes.Line;
import shapes.OddShape;
import shapes.Rectangle;
import shapes.Shapes;
import shapes.Square;
import shapes.Triangle;
/**
 *
 * @author usefw
 */
public class Board extends JPanel implements MouseListener, MouseMotionListener {
    
    Shapes resized=null;
   
   static CurrentShapes c= CurrentShapes.Singleton();
        Color Colour;
    String shape="Line";
          public static String redotype;
          public static int resize;
           Iterator <Shapes> it=CurrentShapes.drawings.iterator();

           
           
    int x1,x2,y1,y2,x3,y3;
    Boolean condition;
    int mode = -1;
    public static Shapes Lastl;
        public static Shapes  Lastr;
           public static  Shapes Lasts;
            public static Shapes Lastc;
            public static Shapes Lastt;
            public static Shapes Lasto;
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
                draw.drawLine(line.getx1(), line.gety1(), line.getx2(), line.gety2());
            }
            else if(hold instanceof Rectangle ){
                Rectangle r = (Rectangle) hold;
                draw.setColor(r.getColor());
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
            else if (hold instanceof Square){
                Square s = (Square) hold;
                draw.setColor(s.getColor());
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
            else if(hold instanceof Circle){
                Circle ci =(Circle) hold;
                draw.setColor(ci.getColor());
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
          
            else if (hold instanceof Triangle ){
                Triangle t=(Triangle)hold;
                draw.setColor(t.getColor());
                draw.drawLine(t.getx1(),t.gety1(),t.getx1(),t.gety2());
                draw.drawLine(t.getx1(),t.gety2(),t.getx2(),t.gety2());
                draw.drawLine(t.getx1(),t.gety1(),t.getx2(),t.gety2());
              
            }
            else if(hold instanceof OddShape){
                OddShape o=(OddShape)hold;
                draw.setColor(o.getColor());
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
        try{
            
            if(!shape.isEmpty() && ! shape.equals("resize") &&! shape.equals("move")){
             x1 = e.getX();
        y1 = e.getY();
        x2=e.getX();
        y2=e.getY();
            c.addshape(shape, x1, y1, x2, y2, Colour); // (GetClassFactory.classgetter(shape,x1,y1,x2,y2,Colour));
            repaint();
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
            System.out.println("selected");
            break;
            }
             
             else if(c.drawings.get(i) instanceof Square){
              resizedshape=(Square)c.drawings.get(i);
            System.out.println("selected");
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
    public void clearLastShape()    //pop
    {
        int size=c.drawings.size();
        try{
        if(c.drawings.get(size-1)  instanceof Circle){
        Lastc=c.drawings.get(size-1);
        redotype="Circle";
        }
         if(c.drawings.get(size-1)  instanceof Rectangle){
         Lastr= c.drawings.get(size-1);
        redotype="Rectangle";
        }
          if(c.drawings.get(size-1)  instanceof Square){
                Lasts=c.drawings.get(size-1);
        redotype="Square";
        }
           if(c.drawings.get(size-1)  instanceof Triangle){
                 Lastt=c.drawings.get(size-1);
        redotype="Triangle";
        }
            if(c.drawings.get(size-1)  instanceof Line){
            
                Lastl=c.drawings.get(size-1);
        redotype="Line";
        }
            if(c.drawings.get(size-1)  instanceof OddShape){
                 Lasto=c.drawings.get(size-1);
        redotype="OddShape";
            }
        
        
        
        
        if(c.drawings.size()>0){
            c.removeshape(); 
          
            
        }
        repaint();
        }catch(Exception ex){
            
        }
    }
    public void clearAllShapes()
    {
                   c.drawings.clear();
                   repaint();
    }
    
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
    if(redotype.equals("OddShape")){
    c.drawings.add(Lasto);
    repaint();
    }
        }catch(Exception ex) {
            
            }

   
    }


 
       

  


    @Override
    public void mouseReleased(MouseEvent e) {
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
