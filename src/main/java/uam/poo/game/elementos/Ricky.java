package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author santi
 */
public class Ricky extends SpriteMobileManual
{
    private int paso;
    
    public static final int SLOW = 5;
    
    public static final int FAST = 8;
    
    public static final int WIDTH = 50; 
    
    public static final int HEIGHT = 50;
    
    public static final Color COLOR  = Color.BLUE; 
    
    public static final int X0 = 0;   

    public Ricky(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);
        paso = SLOW;
    }
    
    public int getPaso()
    {
        return this.paso;
    }            
    
    public void setPaso(int paso)
    {
        this.paso = paso;
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

    @Override
    public void mover(int direccion) 
    {
        switch(direccion)
        {
            case KeyEvent.VK_DOWN:
                rectangle.y+=paso;
                break;
            case KeyEvent.VK_LEFT:
                rectangle.x-=paso;
                break;
            case KeyEvent.VK_RIGHT:
                rectangle.x+=paso;
                break;
            case KeyEvent.VK_UP:
                rectangle.y-=paso;
                break;
            default:
                System.out.println("Direccion Incorrecta"); // Lanzar Excepcion Propia
        }
        contenedor.refrescar();
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(this.getColor());      
        g.fillRect(rectangle.x, rectangle.y, rectangle.height, rectangle.width);
    }    
}
