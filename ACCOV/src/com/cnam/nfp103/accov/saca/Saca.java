/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnam.nfp103.accov.saca;


import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author rkhattar
 */
public class Saca {
    
    static final int portNumber = 223;
    
    
    
    public static void main(String[]args)throws Exception{
         System.out.println("Server UP");
      ServerSocket acceptSocket = new ServerSocket(2233);

        while(true){
         Socket SocketConx = acceptSocket.accept();
          InputStreamReader IR = new InputStreamReader(SocketConx.getInputStream());
            BufferedReader BR = new BufferedReader(IR);
             String Message = BR.readLine();
            System.out.println(Message);
        }

    }
    
     

    
    void connect(Socket connectionSocket){
        
        String resultat; 
        String []s;
       // Console c = new Console();
        try{
       
            BufferedReader inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            PrintWriter outToClient =new PrintWriter(connectionSocket.getOutputStream()); 

            s = inFromClient.readLine().split("/"); //id/nom/arrivee


              //  radar.afficher(s[0], s[1], "0", "0", "0", "0", "0", "0", "0", "0","Depart");
             //   resultat = c.calcul(Double.parseDouble(s[2]),Double.parseDouble(s[3]),Double.parseDouble(s[4]),0,0,0,0,0);
                     resultat  = "ASDSADSADSADAD";

            while (true){

                outToClient.println(resultat);
                outToClient.flush();

                String [] position = inFromClient.readLine().split("/");;
                String [] res = resultat.split("/");
                if((position.length >= 4)&&(position[3].equals("end"))){
                 //   radar.afficher(s[0], s[1], position[0], position[1],position[2], res[0], res[1], res[2], res[3], res[4],"Arrivee");
                    inFromClient.close();
                    outToClient.close();
                    connectionSocket.close();
                }
                else{

                   //     radar.afficher(s[0], s[1], position[0], position[1],position[2], res[0], res[1], res[2], res[3], res[4],"-");
                    //    resultat = c.calcul(Double.parseDouble(position[0]), Double.parseDouble(position[1]),Double.parseDouble(position[2]),Double.parseDouble(res[3]), Double.parseDouble(res[4]));

                }

            }
        }catch(Exception e){System.out.println("arret d'execution"); System.exit(0);}
    }
    
    public static Avion addAvion(String input){
        
        Avion av =new Avion(0,0,0,0,0,0,input,false);
        
        return av;
        
    }
    public static void createAvion(ArrayList<Avion> avions){     
    
      
     JFrame AjouteAvion = new JFrame("Ajouter Avion");
                        JPanel ajouteravionpanel = new JPanel();
                        JLabel numerovol = new JLabel();
                        JTextField jt = new JTextField(10);
                        JButton save =new JButton("Sauvegarder");
                     


                        numerovol.setText("# Vol:");             

                        AjouteAvion.setSize(200,200);
                        AjouteAvion.setVisible(true);
                        AjouteAvion.setLocation(500, 250);
                        AjouteAvion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

                        ajouteravionpanel.add(numerovol);
                        ajouteravionpanel.add(jt);
                        

                        ajouteravionpanel.add(save);
                     

                          AjouteAvion.add(ajouteravionpanel);
                          
                        save.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                 String input = jt.getText();                                
                                 avions.add(addAvion(input));
                                 AjouteAvion.dispatchEvent(new WindowEvent(AjouteAvion, WindowEvent.WINDOW_CLOSING));
                            } 
                          
                          });

                      
    }

    
     public static void showlistAvion(ArrayList<Avion> avions) {
        
                      
                       Object[] columnNames = {"# Vol","Avion"};
                        
                    
                       DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
                       ListeAvionScreen listeav = new ListeAvionScreen();
                      
                       listeav.getTable().setModel(tableModel);
                        //Component[] s = listeav.; 
                        //System.out.print(s);
                        avions.stream().forEach(
                        avion->{ 
                            String numerovol = avion.getNumeroVol();                            
                            Object[] data = {numerovol,avion}; 
                            tableModel.addRow(data);
                                   
                        }
                        );
                         listeav.setVisible(true);
                                        
    }

  

  
   
}
