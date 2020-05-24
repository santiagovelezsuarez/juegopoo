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
 * @author santi
 */
public class Oxygeno extends SpriteEstatico
{
    public static final int WIDTH = 25; 
    
    public static final int HEIGHT = 25; 
    
    public static final Color COLOR  = Color.ORANGE; 
    
    private int cantidad;

    public Oxygeno(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);
        this.cantidad = 20;
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(this.getColor());        
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);  
    }

    public int getCantidad()
    {
        return this.cantidad;
    }
}
