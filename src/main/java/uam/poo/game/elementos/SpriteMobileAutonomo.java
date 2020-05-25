package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author santi
 */
public abstract class SpriteMobileAutonomo extends SpriteMobile implements Runnable
{    
    public SpriteMobileAutonomo(Rectangle rectangle)
    {
        super(rectangle);
    }    
}
