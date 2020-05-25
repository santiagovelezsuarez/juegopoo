package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author santi
 */

public abstract class SpriteMobile extends Sprite
{
    protected int velX;
    
    protected int velY;
    
    protected static final  int DIR_DOWN = 1;
    
    protected static final  int DIR_UP = 2;
    
    protected static final  int DIR_RIGHT = 3;
    
    protected static final  int DIR_LEFT = 4;
    
    public SpriteMobile(Rectangle rectangle) 
    {
        super(rectangle);
    }
    
    public abstract void mover(int direccion);
}
