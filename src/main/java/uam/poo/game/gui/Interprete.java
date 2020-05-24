package uam.poo.game.gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author santi
 */

public interface Interprete
{
    public ArrayList<String> leer(String path) throws FileNotFoundException, IOException ;
    
    public void escibir(ArrayList<String> datos) throws IOException;
}
