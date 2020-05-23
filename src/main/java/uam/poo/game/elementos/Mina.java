package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */

public class Mina extends SpriteEstatico implements Contenedor
{
    private Ricky ricky;
    
    private ArrayList<Enemigo> enemigos;
    
    private ArrayList<Pared> paredes;
    
    private static final int ROCA = 1;
    
    private static final int MURCIELAGO = 2;
    
    public Mina(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);
        this.ricky = new Ricky(new Rectangle(Ricky.X0, rectangle.height-Ricky.HEIGHT, Ricky.WIDTH, Ricky.HEIGHT), Ricky.COLOR);
        this.ricky.setContenedor(this);
        this.enemigos = new ArrayList<>();
        this.paredes = new ArrayList<>();
        generarParedes(); // Temporal se debe generar desde un archivo
    }
    
    //Temporal
    public void generarParedes()
    {
        for(int i=0; i<12; i++)
        {
            int hx = (int) (Math.random() * rectangle.width - Pared.WIDTH);
            int hy = (int) (Math.random() * rectangle.height - Pared.HEIGHT);            
            Pared p = new Pared(new Rectangle(hx, hy, Pared.WIDTH, Pared.HEIGHT), Pared.COLOR);
            p.setContenedor(this);            
            paredes.add(p);            
        }
    }
    
    public void agregarEnemigo(int tipo)
    {
        Enemigo enemigo = null;
        int hx;
        switch(tipo)
        {
            case ROCA:
                hx = (int) (Math.random() * rectangle.width - Roca.WIDTH);
                enemigo = new Roca(new Rectangle(hx, Roca.SCREEN_TOP, Roca.WIDTH, Roca.HEIGHT), Roca.COLOR);               
                break;
            case MURCIELAGO:
                hx = (int) (Math.random() * rectangle.width - Roca.WIDTH);
                enemigo = new Murcielago(new Rectangle(hx, Murcielago.SCREEN_TOP, Murcielago.WIDTH, Murcielago.HEIGHT), Murcielago.COLOR);                
                break;
            default:
                System.err.println("[Mina@agregarEnemigo] tipo incorrecto: " + tipo);
                break;
        }
        if(enemigo != null)
        {
            enemigo.setContenedor(this);
            enemigos.add(enemigo);
            Thread t = new Thread(enemigo);
            t.start();
            contenedor.refrescar();
        }        
    }
    
    public int getDireecionContraria(int direccion)
    {
        if(direccion == KeyEvent.VK_UP)
            return KeyEvent.VK_DOWN;
        if(direccion == KeyEvent.VK_DOWN)
            return KeyEvent.VK_UP;
        if(direccion == KeyEvent.VK_RIGHT)
            return KeyEvent.VK_LEFT;
        if(direccion == KeyEvent.VK_LEFT)
            return KeyEvent.VK_RIGHT;
        return 0;
    }
    
    public boolean hayPared(int direccion)
    {        
        boolean hayPared = false;            
        for(Pared p : paredes)
        {
            if (p.colisiono(ricky))
            {
                return true;                
            }
        }
        return hayPared;        
    }
    
    public void moverRicky(int tecla)
    {
        boolean flag = false;
        Rectangle rr = new Rectangle(ricky.getX(), ricky.getY(), ricky.getWidth(), ricky.getHeight());   
        
        if(tecla == KeyEvent.VK_RIGHT)
        {
            rr.setBounds(ricky.getX()+ricky.getPaso(), ricky.getY(), ricky.getWidth(), ricky.getHeight());    
        }
        if(tecla == KeyEvent.VK_UP)
        {
            rr.setBounds(ricky.getX(), ricky.getY()-ricky.getPaso(), ricky.getWidth(), ricky.getHeight());    
        }
        if(tecla == KeyEvent.VK_DOWN)
        {
            rr.setBounds(ricky.getX(), ricky.getY()+ricky.getPaso(), ricky.getWidth(), ricky.getHeight());    
        }
        if(tecla == KeyEvent.VK_LEFT)
        {
            rr.setBounds(ricky.getX()-ricky.getPaso(), ricky.getY(), ricky.getWidth(), ricky.getHeight());    
        }
        for(Pared p : paredes)
        {
            Rectangle rp = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHeight());
            if(rp.intersects(rr))                
            {
                 flag = true;                
            }
        }
        if(!flag)
            ricky.mover(tecla); 
             
    }
    
    public void keyPressed(int tecla)
    {
        if(tecla == KeyEvent.VK_UP | tecla == KeyEvent.VK_DOWN | tecla == KeyEvent.VK_LEFT | tecla == KeyEvent.VK_RIGHT)
        {
            moverRicky(tecla);    
        }       
       
        if(tecla == KeyEvent.VK_R)
        {
            agregarEnemigo(Mina.ROCA);            
        }
        if(tecla == KeyEvent.VK_M)
        {
            agregarEnemigo(Mina.MURCIELAGO);  
        }       
    }

    @Override
    public void draw(Graphics g) 
    {
        g.setColor(getColor());
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        
        ricky.draw(g);
        
        for(Enemigo enemigo : enemigos)
        {
            enemigo.draw(g);
        }
        
        for(Pared pared : paredes)
        {
            pared.draw(g);
        }
    }

    @Override
    public void refrescar() 
    {
        contenedor.refrescar();
    }

    @Override
    public Rectangle getDimension() 
    {
        return rectangle;
    }    
}
