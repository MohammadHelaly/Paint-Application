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
import java.util.ArrayList;
/**
 *
 * @author Helaly
 */
public class Eraser extends Shapes{
    public ArrayList<Integer> xPositions;
    public ArrayList<Integer> yPositions;

    public Eraser(int x1,int x2,int y1,int y2,Color c,int stroke,boolean isfilled) {
        super(x1,x2,y1,y2,c,stroke,isfilled);
        xPositions = new ArrayList<>();
        yPositions = new ArrayList<>();
    }
    
    @Override
    public boolean contains(int p1, int p2) {
                return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
