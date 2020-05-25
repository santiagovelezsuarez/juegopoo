package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import uam.poo.game.utils.Coordenada;

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
    
    private final String RICKY = "r";
    
    private final String DIAMANTE = "d";
    
    private final String OXIGENO = "o";
    
    private final String PARED = "*";
    
    public Mina(Rectangle rectangle) 
    {
        super(rectangle);
         try {
            imagen=ImageIO.read(new File("./src/main/java/RickyGame/textures/fondo.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Diamante.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.ricky = new Ricky(new Rectangle(Ricky.X0, rectangle.height-Ricky.HEIGHT-BORDE, Ricky.WIDTH, Ricky.HEIGHT), Ricky.COLOR);
        //this.ricky.setContenedor(this);
        //this.diamante=new Diamante(new Rectangle(rectangle.width-Diamante.WIDTH-BORDE,BORDE,Diamante.WIDTH,Diamante.HEIGHT),Diamante.COLOR);
        //this.diamante.setContenedor(this);
        this.oxygenos = new ArrayList<>();
        this.enemigos = new ArrayList<>();
        this.paredes = new ArrayList<>();
        dibujarBordes(); 
        
        //generarOxygenos();
    }
        
    
    public void dibujarBordes()
    {
        Pared p1 = new Pared(new Rectangle(0, 0, rectangle.width, BORDE));
        p1.setContenedor(this);            
        paredes.add(p1);
        Pared p2 = new Pared(new Rectangle(0, 0, BORDE, rectangle.height));
        p2.setContenedor(this);            
        paredes.add(p2);
        Pared p3 = new Pared(new Rectangle(0, rectangle.height-BORDE, rectangle.width, BORDE));
        p3.setContenedor(this);            
        paredes.add(p3);
        Pared p4 = new Pared(new Rectangle(rectangle.width-BORDE, 0, BORDE, rectangle.height));
        p4.setContenedor(this);            
        paredes.add(p4);
        //Temporal
        /*for(int i=0; i<12; i++)
        {
            int hx = (int) (Math.random() * rectangle.width - Pared.WIDTH);
            int hy = (int) (Math.random() * rectangle.height - Pared.HEIGHT);            
            Pared p = new Pared(new Rectangle(hx, hy, Pared.WIDTH, Pared.HEIGHT), Pared.COLOR);
            p.setContenedor(this);            
            paredes.add(p);            
        }*/
    }
    
    public void cargarMurcielagos(int cantidad)
    {
        for(int i=0;i<cantidad;i++)
        {
           this.agregarEnemigo(MURCIELAGO);
        }        
    }
           
    public void cargarMapa(ArrayList<String> mapa) 
    {
        for(int i=0; i<mapa.size(); i++)
        {
            if(mapa.get(i).equals(RICKY))                
            {
                Coordenada c = getCoordenada(i);
                this.ricky = new Ricky(new Rectangle(c.getX(), c.getY(), getWidthCelda(), getHeightCelda()));
                this.ricky.setContenedor(this);
            }
            else if(mapa.get(i).equals(DIAMANTE))
            {
                Coordenada c = getCoordenada(i);
                this.diamante=new Diamante(new Rectangle(c.getX(), c.getY(),getWidthCelda(), getHeightCelda()));
                this.diamante.setContenedor(this);
            }
            else if(mapa.get(i).equals(OXIGENO))
            {                
                Coordenada c = getCoordenada(i);
                Oxygeno o = new Oxygeno(new Rectangle(c.getX(), c.getY(), getWidthCelda(), getHeightCelda()));
                o.setContenedor(this);
                oxygenos.add(o);
            }
            else if(mapa.get(i).equals(PARED))
            {
                Coordenada c = getCoordenada(i);
                Pared p = new Pared(new Rectangle(c.getX(), c.getY(), getWidthCelda(), getHeightCelda()));
                p.setContenedor(this);            
                paredes.add(p); 
            }
        }
    }
    
    private int getWidthCelda()
    {
        Rectangle dimension = contenedor.getDimension();
        int width = dimension.width - 2*BORDE;
        int factorX = width/10;
        return factorX;
    }
    
    private int getHeightCelda()
    {
        Rectangle dimension = contenedor.getDimension();
        int height = dimension.height - 2*BORDE;
        int factorY = height/10;
        return factorY;
    }
    
    private Coordenada getCoordenada(int i)
    {                
        int x = i%10;        
        int y = i/10;        
        int factorX = getWidthCelda();
        int factorY = getHeightCelda();        
        x = (x*factorX)+BORDE;
        y = (y*factorY)+BORDE;        
        return new Coordenada(x, y);      
        
    }
    
    public void destruirPared()
    {
        // TODO: 
    }
    
        
    public void agregarEnemigo(int tipo)
    {
        Enemigo enemigo = null;
        int hx;
        switch(tipo)
        {
            case ROCA:
                hx = (int) (Math.random() * rectangle.width - Roca.WIDTH);
                enemigo = new Roca(new Rectangle(hx, Roca.SCREEN_TOP, Roca.WIDTH, Roca.HEIGHT));               
                break;
            case MURCIELAGO:
                hx = (int) (Math.random() * rectangle.width - Roca.WIDTH);
                enemigo = new Murcielago(new Rectangle(hx, Murcielago.SCREEN_TOP, Murcielago.WIDTH, Murcielago.HEIGHT));                
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
        {             
            ricky.mover(tecla);
            ricky.setPaso(Ricky.SLOW);
        }             
        else
        {
           ricky.setPaso(Ricky.MIN);       
        }
                  
        
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
    
    private int getKeyRandom()
    {
        int teclas[] = {KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT};
        return teclas[(int)(Math.random()*teclas.length)];        
    }
      
    
    public void keyPressed(int tecla)
    {
        if(tecla == KeyEvent.VK_UP | tecla == KeyEvent.VK_DOWN | tecla == KeyEvent.VK_LEFT | tecla == KeyEvent.VK_RIGHT)
        {
            moverRicky(tecla);    
        }       
        if(tecla == KeyEvent.VK_SPACE)
        {
            destruirPared();            
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
        g.drawImage(imagen, rectangle.x,rectangle.y, rectangle.width, rectangle.height, null);
        //g.setColor(getColor());
        //g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        
        
        for(Pared pared : paredes)
        {
            pared.draw(g);       
            System.out.println("Pared "+pared.rectangle);
        }
        
        for(Oxygeno ox : oxygenos)
        {
            ox.draw(g);   
            System.out.println("Ox :"+ox.rectangle);
        }
        
        ricky.draw(g);
        System.out.println("Ricky "+ricky.rectangle);
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
        verificarColisiones();
    }

    @Override
    public Rectangle getDimension() 
    {
        return rectangle;
    } 
    
    private void verificarColisiones() 
    {
        for(Enemigo e : enemigos)      
        {
            if(e.colisiono(ricky))
            {        
                e.colisionar();                
                moverRicky(getKeyRandom());
                ricky.quitarOxigeno(e.damage);
                System.out.println("AHORA TU OXIGENO ES DE: "+ricky.getOxigeno());                 
            }
        }
    }
}
