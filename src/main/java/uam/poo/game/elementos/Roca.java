package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */

public class Roca extends Enemigo
{
    public static final int WIDTH = 30; 
    
    public static final int HEIGHT = 30; 
    
    public static final int SCREEN_TOP = 0; 
    
    public static final Color COLOR  = Color.GRAY;   

    public Roca(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);
        running = true;
        damage=5;
    }    

    @Override
    public void mover(int direccion)
    {
        if(direccion == KeyEvent.VK_DOWN)
        {
            rectangle.y +=30;        
            if(rectangle.y>=contenedor.getDimension().height)
            {
                rectangle.y=0;
                rectangle.x=(int)(Math.random()*contenedor.getDimension().width+1);
            }
        }            
           
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(this.getColor());
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public void colisionar() 
    {
        rectangle.y = contenedor.getDimension().height;
    }   

    @Override
    public void run() 
    {        
        while(running)
        {
            mover(KeyEvent.VK_DOWN);
            //contenedor.refrescar();
            try 
            {
                Thread.sleep(100);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Roca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
