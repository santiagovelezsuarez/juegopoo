package uam.poo.game.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import uam.poo.game.gui.Interprete;

/**
 *
 * @author santi
 */

public class GestorArchivoPlano implements Interprete
{  
    @Override
    public ArrayList<String> leer(String path) throws FileNotFoundException, IOException 
    {
        ArrayList<String> file = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));        
        String line;
        while ((line = br.readLine()) != null) 
        {
            String[] split = line.split(",");
            for(int i=0; i<split.length; i++)
                file.add(split[i]);
        }
        br.close();
        return file;
    }
   
    @Override    
    public void escibir(ArrayList<String> datos) throws IOException
    {
        Charset charset = Charset.forName("UTF-8");              
        Path outFile = Paths.get("salida.txt");
        BufferedWriter writer = Files.newBufferedWriter(outFile, charset);
        for(int i=0; i<datos.size(); i++)
            writer.write(datos.get(i)+"\n", 0, datos.get(i).length()+1);
        writer.close();
    }    
}
