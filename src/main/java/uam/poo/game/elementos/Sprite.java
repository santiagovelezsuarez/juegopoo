package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author santi
 */

public abstract class Sprite 
{
    protected Rectangle rectangle;
    
    protected Color color;
    
    protected Contenedor contenedor;
    
    public Sprite(Rectangle rectangle, Color color)
    {
        this.rectangle = rectangle;
        this.color = color;
    }
    
    public abstract void draw(Graphics g);
    
    public boolean colisiono(Sprite sprite)
    {
        return this.rectangle.intersects(sprite.rectangle);
    }
    
    public void setContenedor(Contenedor contenedor)
    {
        this.contenedor = contenedor;
    }
    
    public Color getColor()
    {
        return color;
    }
}
