package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author santi
 */
public class Ricky extends SpriteMobileManual 
{
    private int paso;
    
    private int oxigeno;
    
    public static final int OXIGENOINICIAL=100;
    
    public static final int MIN = 1;
    
    public static final int SLOW = 5;
    
    public static final int FAST = 8;    
    
    public static final Color COLOR  = Color.BLUE; 
    
    public static final int X0 = 5;   

    public Ricky(Rectangle rectangle) 
    {
        super(rectangle);
        paso = SLOW;       
        oxigeno=OXIGENOINICIAL;
         try {
            imagen=ImageIO.read(new File("./src/main/java/RickyGame/textures/SpriteSheetMinero.png"));
        } catch (IOException ex) {
            Logger.getLogger(Diamante.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public int getOxigeno() {
        return oxigeno;
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

    public void quitarOxigeno(int danio)
    {
        if((this.oxigeno - danio)<0)
            this.oxigeno = 0;
        else
            this.oxigeno-=danio;        
    }
    
    public void cojerOxigeno(int cant)
    {
        if((this.oxigeno + cant)>100)
            this.oxigeno = 100;
        else
            this.oxigeno+=cant;
    }
    
    public void agitarse()
    {
        int random = (int)(Math.random()*10);
        if(random == 1)
            quitarOxigeno(1); 
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
        g.drawImage(imagen, rectangle.x,rectangle.y, rectangle.width, rectangle.height, null);
       // g.setColor(this.getColor());      
        //g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }    
}
