package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author santi
 */

public abstract class Sprite 
{
    protected Rectangle rectangle;
    
    protected BufferedImage imagen;
    
    protected Contenedor contenedor;
    
    public Sprite(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        
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

    public BufferedImage getImagen() {
        return imagen;
    }
    
    
}
