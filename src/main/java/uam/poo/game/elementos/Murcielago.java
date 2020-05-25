/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author santi
 */
public class Murcielago extends Enemigo
{
    public static final int VELOCIDAD=35;
    
    public static final int WIDTH = 30; 
    
    public static final int HEIGHT = 30; 
    
    public static final int SCREEN_TOP = 0; 
    
    public static final Color COLOR  = Color.BLACK;     
    

    public Murcielago(Rectangle rectangle) 
    {
        super(rectangle);
        running = true;
        damage = (int)(Math.random()*4+1);
        velX=VELOCIDAD;
         try {
            imagen=ImageIO.read(new File("./src/main/java/RickyGame/textures/murcielago.png"));
        } catch (IOException ex) {
            Logger.getLogger(Diamante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public void mover(int direccion)
    {      
      int tx=rectangle.x;
      int ty=rectangle.y;
      
      switch(direccion)
      {
          case 1:
              ty +=velX;
              break;
          case 2:
              ty -=velX;
              break;
          case 3:
              tx +=velX;
              break;
          case 4:
              tx -=velX;
              break;          
      }
      
      Rectangle rectangulo=contenedor.getDimension();
      
      if(tx<=rectangulo.width-WIDTH& tx>=0 & ty<=rectangulo.height-HEIGHT & ty>=Mina.INFO )
      {
          rectangle.x=tx;
          rectangle.y=ty;
      }               
        
    }   
    

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(imagen, rectangle.x,rectangle.y, rectangle.width, rectangle.height, null);
       // g.setColor(this.getColor());
       //g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public void colisionar() 
    {
        rectangle.y=(int)(Math.random()*contenedor.getDimension().height);
        Random r = new Random();
        if(r.nextBoolean())
            rectangle.x=contenedor.getDimension().width-rectangle.width-1;
        else
            rectangle.x=0;
        
    }
    
    public int dirRandom()
    {
        return (int)(Math.random()*4+1);
    }
    

    @Override
    public void run() 
    {        
        while(running)
        {
            mover(dirRandom());
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
