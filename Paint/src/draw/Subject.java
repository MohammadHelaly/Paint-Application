/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import java.awt.Color;

/**
 *
 * @author usefw
 */
public interface  Subject {
    abstract void addshape(String shape,int x1,int y1,int x2,int y2,Color Colour);
      abstract void removeshape();
    
}
