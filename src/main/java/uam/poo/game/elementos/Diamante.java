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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author JUAN DAVID
 */
public class Diamante extends SpriteEstatico
{ 
    public static final Color COLOR  = Color.GREEN; 
    
    public Diamante(Rectangle rectangle) 
    {
        super(rectangle);
        
        try {
            imagen=ImageIO.read(new File("./src/main/java/RickyGame/textures/Diamante.png"));
        } catch (IOException ex) {
            Logger.getLogger(Diamante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    @Override
    public void draw(Graphics g) 
    {
        g.drawImage(imagen, rectangle.x,rectangle.y, rectangle.width, rectangle.height, null);
      // g.setColor(this.getColor());        
      //g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height); 
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
