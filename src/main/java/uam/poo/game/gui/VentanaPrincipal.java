/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.poo.game.gui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import uam.poo.game.elementos.Contenedor;
import uam.poo.game.elementos.Mina;

/**
 *
 * @author santi
 */
public class VentanaPrincipal extends javax.swing.JFrame implements Contenedor
{
    private Mina mina;  
    
    private final BufferStrategy bf;
   
    public VentanaPrincipal() 
    {
        this.setUndecorated(true);       
        initComponents();         
        createBufferStrategy(4);
        bf = this.getBufferStrategy();
    }
    
    public void setMina(Mina mina)
    {
        this.mina = mina;
    }
    
    @Override
    public void paint(Graphics g) 
    {
        bf.show();
        mina.draw(g);
    }
    
    @Override
    public void refrescar() 
    {
        this.repaint();        
    }

    @Override
    public Rectangle getDimension()
    {
        return this.getBounds();
    }
    
    

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_Q)
            System.exit(0);
        
        mina.keyPressed(evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
