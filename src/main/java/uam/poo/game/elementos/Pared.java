package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author santi
 */
public class Pared extends SpriteEstatico
{    
    public static final int WIDTH = 100; 
    
    public static final int HEIGHT = 30; 
    
    public static final Color COLOR  = Color.RED; 
    
    public static final int HORIZONTAL  = 1; 
    
    public static final int VERTICAL  = 2;    
    
    private int resistencia;    

    public Pared(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);        
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(this.getColor());        
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);        
    }
}