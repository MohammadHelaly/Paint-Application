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
public class Brush extends Shapes{
    public ArrayList<Integer> xcoordinates = new ArrayList<>();
    public ArrayList<Integer> ycoordinates = new ArrayList<>();

    public Brush(Color c) {
        super(c);
    }

    @Override
    public boolean contains(int p1, int p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}