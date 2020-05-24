package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */

public class Mina extends SpriteEstatico implements Contenedor
{
    private Ricky ricky;
    
    private Diamante diamante;
    
    private ArrayList<Oxygeno> oxygenos;
    
    private ArrayList<Enemigo> enemigos;
    
    private ArrayList<Pared> paredes;
    
    private static final int ROCA = 1;
    
    private static final int MURCIELAGO = 2;
    
    private final int BORDE = 5;
    
    public Mina(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);
        this.ricky = new Ricky(new Rectangle(Ricky.X0, rectangle.height-Ricky.HEIGHT-BORDE, Ricky.WIDTH, Ricky.HEIGHT), Ricky.COLOR);
        this.ricky.setContenedor(this);
        this.diamante=new Diamante(new Rectangle(rectangle.width-Diamante.WIDTH-BORDE,BORDE,Diamante.WIDTH,Diamante.HEIGHT),Diamante.COLOR);
        this.diamante.setContenedor(this);
        this.oxygenos = new ArrayList<>();
        this.enemigos = new ArrayList<>();
        this.paredes = new ArrayList<>();
        generarParedes(); // Temporal se debe generar desde un archivo
        generarOxygenos();
    }
    
    public void generarOxygenos()
    {
        for(int i=0; i<10; i++)
        {
            agregarOxygeno();
        }
    }
    
    
    public void generarParedes()
    {
        Pared p1 = new Pared(new Rectangle(0, 0, rectangle.width, BORDE), Pared.COLOR);
        p1.setContenedor(this);            
        paredes.add(p1);
        Pared p2 = new Pared(new Rectangle(0, 0, BORDE, rectangle.height), Pared.COLOR);
        p2.setContenedor(this);            
        paredes.add(p2);
        Pared p3 = new Pared(new Rectangle(0, rectangle.height-BORDE, rectangle.width, BORDE), Pared.COLOR);
        p3.setContenedor(this);            
        paredes.add(p3);
        Pared p4 = new Pared(new Rectangle(rectangle.width-BORDE, 0, BORDE, rectangle.height), Pared.COLOR);
        p4.setContenedor(this);            
        paredes.add(p4);
        //Temporal
        for(int i=0; i<12; i++)
        {
            int hx = (int) (Math.random() * rectangle.width - Pared.WIDTH);
            int hy = (int) (Math.random() * rectangle.height - Pared.HEIGHT);            
            Pared p = new Pared(new Rectangle(hx, hy, Pared.WIDTH, Pared.HEIGHT), Pared.COLOR);
            p.setContenedor(this);            
            paredes.add(p);            
        }
    }
    
    public void cargarMurcielagos(int cantidad)
    {
        for(int i=0;i<cantidad;i++)
        {
           this.agregarEnemigo(MURCIELAGO);
        }        
    }
    
    public void agregarOxygeno()
    {
        int hx = (int) (Math.random() * rectangle.width - Oxygeno.WIDTH);
        int hy = (int) (Math.random() * rectangle.height - Oxygeno.HEIGHT);
        Oxygeno o = new Oxygeno(new Rectangle(hx, hy, Oxygeno.WIDTH, Oxygeno.HEIGHT), Oxygeno.COLOR);
        o.setContenedor(this);        
        oxygenos.add(o);
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
        
        
        if(ricky.colisiono(diamante))
            JOptionPane.showMessageDialog(null,"llego al diamante");
        
        for(int i=0; i<oxygenos.size(); i++)
        {
            Oxygeno ox = oxygenos.get(i);
            if(ricky.colisiono(ox))
            {
                ricky.cojerOxigeno(ox.getCantidad());
                oxygenos.remove(ox);
                System.out.println("Oxygeno = "+ricky.getOxigeno());
            }
        }            
       
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
        
        
        for(Pared pared : paredes)
        {
            pared.draw(g);
        }
        
        for(Oxygeno ox : oxygenos)
        {
            ox.draw(g);
        }
        
        ricky.draw(g);
        diamante.draw(g);
        for(Enemigo enemigo : enemigos)
        {
            enemigo.draw(g);
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

    @Override
    public void verificarColisiones() 
    {
        for(Enemigo e : enemigos)      
        {
            if(e.colisiono(ricky))
            {        
                e.colisionar();                
                ricky.mover(KeyEvent.VK_RIGHT);
                ricky.quitarOxigeno(e.damage);
                System.out.println("AHORA TU OXIGENO ES DE: "+ricky.getOxigeno());                 
            }
        }
    }
}
