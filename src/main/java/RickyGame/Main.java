package RickyGame;

import java.awt.Color;
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
        ventanaPrincipal.setSize(800, 600);
        
        Mina mina = new Mina(new Rectangle(0, 0, ventanaPrincipal.getWidth(), ventanaPrincipal.getHeight()), Color.yellow);
        ventanaPrincipal.setMina(mina);
        mina.setContenedor(ventanaPrincipal);
        mina.cargarMurcielagos(3);
        ventanaPrincipal.setVisible(true);        
    }    
}
