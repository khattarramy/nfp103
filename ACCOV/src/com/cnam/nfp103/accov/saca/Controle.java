/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnam.nfp103.accov.saca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author rkhattar
 */
public class Controle {
    
    private static JFrame frame;
    private static JPanel panel;
   
  
    
     
    public static void main(String[]args)throws Exception{
        Saca midleware =new Saca(); 
     
       
        
    JFrame.setDefaultLookAndFeelDecorated(true);   
           JButton showlistavion =new JButton("Voir la liste des avions");
        frame = new JFrame("Console Controle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        panel = new JPanel();
        panel.setVisible(true);      
       
        panel.add(showlistavion);
        
        ArrayList<Avion> avions = new ArrayList(); 
       
     
         showlistavion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                midleware.showlistAvion(avions);                  
            }                           
        });
      
        frame.add(panel);
        frame.setSize(500,500);
        frame.setLocation(500, 250);
        frame.setVisible(true);
          

        
    }

}
