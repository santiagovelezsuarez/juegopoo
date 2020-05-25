package RickyGame;

import java.awt.Rectangle;
import uam.poo.game.elementos.Mina;
import uam.poo.game.gui.VentanaPrincipal;

/**
 *
 * @author santi
 */
public class Main 
{   
    public static void main(String[] args) 
    {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();        
        ventanaPrincipal.setSize(800, 800);
        ventanaPrincipal.setLocationRelativeTo(null);
        Mina mina = new Mina(new Rectangle(0, 0, ventanaPrincipal.getWidth(), ventanaPrincipal.getHeight()));
        ventanaPrincipal.setMina(mina);
        mina.setContenedor(ventanaPrincipal);
        mina.leerMapa();
        mina.cargarMurcielagos(3);
        ventanaPrincipal.setVisible(true);     
    }    
}
