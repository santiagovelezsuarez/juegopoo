package RickyGame;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.poo.game.elementos.Mapa;
import uam.poo.game.elementos.Mina;
import uam.poo.game.gui.VentanaPrincipal;
import uam.poo.game.utils.GestorArchivoPlano;

/**
 *
 * @author santi
 */
public class Main 
{   
    public static void main(String[] args) 
    {
        ArrayList<String> mapa=null;
        Mapa m = new Mapa();
        m.setInerprete(new GestorArchivoPlano());
        try 
        {
            mapa = m.getMapa("./src/main/java/mapas/mapa01.txt");            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();        
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setLocationRelativeTo(null);
        Mina mina = new Mina(new Rectangle(0, 0, ventanaPrincipal.getWidth(), ventanaPrincipal.getHeight()));
        ventanaPrincipal.setMina(mina);
        mina.setContenedor(ventanaPrincipal);
        mina.cargarMapa(mapa);
        mina.cargarMurcielagos(3);
        ventanaPrincipal.setVisible(true);     
    }    
}
