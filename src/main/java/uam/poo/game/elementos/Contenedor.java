package uam.poo.game.elementos;

import java.awt.Rectangle;

/**
 *
 * @author santi
 */

public interface Contenedor 
{
    public void refrescar();
    
    public void verificarColisiones();
    
    public Rectangle getDimension();
}
