/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.poo.game.elementos;

import java.io.IOException;
import java.util.ArrayList;
import uam.poo.game.gui.Interprete;

/**
 *
 * @author santi
 */
public class Mapa 
{
    private Interprete interprete;  
    
    private ArrayList<String> elementos;
    
    public Mapa()
    {
        
    }
    
    public void setInerprete(Interprete interprete)
    {
        this.interprete = interprete;
    }

    public ArrayList<String> getMapa(String path) throws IOException 
    {
        return interprete.leer(path);
    }     
     
}
