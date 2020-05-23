/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Murcielago extends Enemigo
{
    public static final int WIDTH = 30; 
    
    public static final int HEIGHT = 30; 
    
    public static final int SCREEN_TOP = 0; 
    
    public static final Color COLOR  = Color.BLACK; 
    
    private boolean running;

    public Murcielago(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);
        running = true;
    }    

    @Override
    public void mover(int direecion)
    {
        rectangle.y +=1;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(this.getColor());
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public void run() 
    {        
        while(running)
        {
            mover(DIR_DOWN);
            contenedor.refrescar();
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
