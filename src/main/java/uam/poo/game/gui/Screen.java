/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.poo.game.gui;

import java.util.Random;

/**
 *
 * @author JUAN DAVID
 */
public class Screen {
      private int width;
    private int height;
    private int[] pixels;
    //private Castle castle;
    
    public int xOffset, yOffset;
//    
//    public final int MAP_SIZE = 64;
//    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
//    
//    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    
    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        
        pixels = new int[width * height];
        
//        for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++){
//            tiles[i] = random.nextInt(0xffffff);
//        }
    }
    
    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0;
        }
    }
    
        
    public void draw(int xOffSet, int yOffSet){
        
    }

    
//    public void renderTile(int xp, int yp, Tile tile){
//        xp -= xOffset;
//        yp -= yOffset;
//        for(int y = 0; y < tile.sprite.SIZE; y++){
//            int ya = y + yp;
//            for(int x = 0; x < tile.sprite.SIZE; x++){
//                int xa = x + xp;
//                if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height){
//                    break;
//                }
//                if(xa < 0) xa = 0;
//                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
//            }
//        }
//    }
//
    public void setOffset(int xOffset,int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    /**
     * getter and setter
     */
    
    public int[] getPixels() {
        return pixels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

  
    
}
