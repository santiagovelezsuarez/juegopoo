/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author JUAN DAVID
 */
public class Diamante extends SpriteEstatico {

    
    public static final int WIDTH = 90; 
    
    public static final int HEIGHT = 90; 
    
    public static final Color COLOR  = Color.GREEN; 
    
    public Diamante(Rectangle rectangle, Color color) {
        super(rectangle, color);
    }


    
    
    @Override
    public void draw(Graphics g) {
       g.setColor(this.getColor());        
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height); 
    }

   public int getX()
    {
        return rectangle.x;
    }
    
    public int getY()
    {
        return rectangle.y;
    }
    
    public int getWidth()
    {
        return rectangle.width;
    }
    
    public int getHeight()
    {
        return rectangle.height;
    }

   

  
    
}
