/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnam.nfp103.accov.saca;



import static com.cnam.nfp103.accov.saca.Saca.portNumber;
import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.*;



/**
 *
 * @author rkhattar
 */
public class Avion {
        static final int wait = 1000;//millisecondes  
        private int x; // position x
	private int y; // position y
        private int z; // position z alltitude
        Vector<Integer> vitesse = new Vector<Integer>(3); //Vecteur Vitesse (cap,pousé,accéleration)
        private int cap; //cap (angle)
        private int pousse; //poussé (+ / - )
	private int acc; //accéleration
        private String numerovol; //numéro du Vol
        private boolean vol;
        static final int port = 350;
        static final String host = "localhost";
        public Avion(int _x, int _y, int _z, int _cap , int _poussse, int _acc, String _numerovol, boolean _vol)
        {
            x=_x;
            y=_y;
            z=_z;
          
            pousse=_poussse;
            acc=_acc;
            numerovol=_numerovol;
            
            vol=_vol;
          // System.out.println("New Airplane created and ready for take off  for the flight: "+numerovol);
            
        }

    //Getters
    public int getX() {
      return x;
    }
    public int getY() {
      return y;
    }
    public int getZ() {
      return z;
    }
   
    public int getCap() {
      return cap;
    }
    public int getPousse() {
      return pousse;
    }
    
    public int getAcc() {
      return acc;
    }
    public String getNumeroVol() {
      return numerovol;
    }
    
    public boolean getVol() {
      return vol;
    }
    
    
    //Setters
    public void setX(int _x){
        x=_x;
    }
    
    public void setY(int _y){
        y=_y;
    }
    public void setZ(int _z){
        z=_z;
    }
    public void setCap(int _cap){
        cap=_cap;
    }
    public void setPousse(int _pousse){
        pousse=_pousse;
    }
    public void setAcc(int _acc){
        acc=_acc;
    }
    
    public void setNumeroVol(String _numerovol){
        numerovol=_numerovol;
    }  
    
     public void setVol(boolean _vol){
        vol=_vol;
    }  
        
      
	
    public void voler(int x,int y, int z,int cap, int pousse,int acc) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cap = cap;
        this.pousse = pousse;
        this.acc = acc;
        
        
    
		
    }

       

        public void envoyerInformation() throws IOException{
            
            // open socket connection
            Socket clSckt = new Socket(host,port);
            
            PrintWriter SendToSaca = new PrintWriter(clSckt.getOutputStream());
            BufferedReader RcvFromSaca = new BufferedReader(new InputStreamReader(clSckt.getInputStream()));
            
            
            SendToSaca.println( numerovol + "/" + x + "/" + y + "/" + z ); //evoie id/nom/arrivee
            SendToSaca.flush();
            //close socket connection
            clSckt.close();
          
           
            
        }

   }


