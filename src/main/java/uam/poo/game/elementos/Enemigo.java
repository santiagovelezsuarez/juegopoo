/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.poo.game.elementos;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author santi
 */
public abstract class Enemigo extends SpriteMobileAutonomo
{
    protected int damage;
    
    public Enemigo(Rectangle rectangle, Color color) 
    {
        super(rectangle, color);
    }    
}
