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
    
    public static final Color COLOR  = Color.RED;      
    
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