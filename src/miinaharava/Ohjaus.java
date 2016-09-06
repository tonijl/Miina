package miinaharava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.applet.*;
import java.io.File;
import java.net.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Ohjaus extends JPanel implements ActionListener, KeyListener,
        MouseListener, MouseMotionListener {

    Timer t = new Timer(5, this);
    double x = 300, y = 500, velx = 0, vely = 0;
    int p = 0;
    int random;
    int koko=10;
    int ruudunkoko=30;
    int luku;
    int miinat = 50;
    
    

    
    String polku = "";
    String miina = "velho1.png";
   
    
    
    List<Ruutu> ruudut = new ArrayList<Ruutu>();
   

    // Pisara pisara1 = new Pisara();
    //Pallo pallo1 = new Pallo();
    public Ohjaus() {
        t.start();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.WHITE);
        
        // pallo1.setVipu(true);

        polku=(getClass().getResource(".").getPath()); 


        for(int i=0; i<koko; i++){
            
            for(int j=0; j<koko; j++){
                
                 random = (int) (Math.random() * 10 +1);
                 System.out.println(i+" "+j);

                 if(random>8){
                    ruudut.add(new Ruutu(j*ruudunkoko,i*ruudunkoko,true,j+1,i+1));
                     
                 }else{
                    ruudut.add(new Ruutu(j*ruudunkoko,i*ruudunkoko,false,j+1,i+1));  
                 }
            }
        }
        //------------------------------------------
        
        
        
        
        //------------------------------------------
        for(int i=0;i<ruudut.size();i++){
            luku=0;
            //System.out.println(i);
            if(i-1>=0&&ruudut.get(i).getVaaka()>1){
                if(ruudut.get(i-1).isMiina()){ //ok
                    System.out.println("eka "+i);
                luku++;
            }
                }
            if(i+1<(koko*koko)&&ruudut.get(i).getVaaka()<koko){  //ok
                if(ruudut.get(i+1).isMiina()){
                    System.out.println("toka "+i);
                luku++;
            }
                }
            if(i-koko>=0&&ruudut.get(i).getPysty()>=1){
                //System.out.println(ruudut.get(i).getY()+" "+(i));
                if(ruudut.get(i-koko).isMiina()){   //ok
                    System.out.println("kolmas "+i);
                luku++;
            }
                }
            if(i+koko<(koko*koko)&&ruudut.get(i).getPysty()<koko){   //ok
               // System.out.println(i);
            if(ruudut.get(i+koko).isMiina()){
                System.out.println("nelj "+i);
                luku++;
            }
            }
            if(i-koko-1>=0&&ruudut.get(i).getPysty()>=1&&ruudut.get(i).getVaaka()>1){     //ok
            if(ruudut.get(i-koko-1).isMiina()){
                System.out.println("viis "+i);
                luku++;
            }
            }
            if(i-koko+1>=0&&ruudut.get(i).getPysty()>=1&&ruudut.get(i).getVaaka()<koko){   //ok
            if(ruudut.get(i-koko+1).isMiina()){
                System.out.println("kuus "+i);
                luku++;
            }
            }
            if(i+koko-1<koko*koko&&ruudut.get(i).getPysty()<koko&&ruudut.get(i).getVaaka()>1){   //ok
            if(ruudut.get(i+koko-1).isMiina()){
                System.out.println("seit "+i);
                luku++;
            }
            }
            if(i+koko+1<koko*koko&&ruudut.get(i).getPysty()<koko&&ruudut.get(i).getVaaka()<koko){
               // System.out.println(ruudut.get(i).getX()+" "+ruudut.get(i).getY());
            if(ruudut.get(i+koko+1).isMiina()){
                System.out.println("kahe "+i);
                luku++;
            }
            }
            
            ruudut.get(i).setNumero(luku);
            luku=0;
        }
        
        //System.out.println("haa");
        

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        
       // g2d.translate(this.getWidth()/2, this.getHeight()/2);
       // g2d.rotate(angle);
        
        ImageIcon mine = new ImageIcon(polku + miina);
        
        
        g.setColor(Color.BLACK);
        for(int i=0;i<ruudut.size();i++){
            
            if(ruudut.get(i).isHidden()){
               g.setColor(Color.GRAY);
               g.fillRect(ruudut.get(i).getX(), ruudut.get(i).getY(), ruudunkoko, ruudunkoko);
               
            }else if(ruudut.get(i).isMiina()){
                g.setColor(Color.RED);
                g.fillRect(ruudut.get(i).getX(), ruudut.get(i).getY(), ruudunkoko, ruudunkoko);
            }else{
                g.setColor(Color.WHITE);
                g.fillRect(ruudut.get(i).getX(), ruudut.get(i).getY(), ruudunkoko, ruudunkoko);
                g.setColor(Color.BLACK);
                g.drawString(""+ruudut.get(i).getNumero(), ruudut.get(i).getX()+(ruudunkoko/2), ruudut.get(i).getY()+(ruudunkoko/2));
                
            }
        
            if(ruudut.get(i).isLippu()){
                g.setColor(Color.GREEN);
                g.fillRect(ruudut.get(i).getX(), ruudut.get(i).getY(), ruudunkoko, ruudunkoko);
            }
            
        
    }
        
        for(int i=0;i<ruudut.size();i++){
               g.setColor(Color.BLACK); 
            g.drawRect(ruudut.get(i).getX(), ruudut.get(i).getY(), ruudunkoko, ruudunkoko);
        }
        
    }

    public void actionPerformed(ActionEvent e) {
        

        
         paljasta();

        repaint();
    }
    


    public void reset() {

     

    }


    public void paljasta(){
        
        for(int i=0;i<ruudut.size();i++){
            
            if (ruudut.get(i).getNumero()==0&&ruudut.get(i).isHidden()==false){
                
                
                if(i-1>=0&&ruudut.get(i).getVaaka()>1){
                ruudut.get(i-1).setHidden(false);
                }
                if(i+1<(koko*koko)&&ruudut.get(i).getVaaka()<koko){
                ruudut.get(i+1).setHidden(false);
                }
                if(i-koko>=0&&ruudut.get(i).getPysty()>=1){
                    ruudut.get(i-koko).setHidden(false);
                }
                if(i+koko<(koko*koko)&&ruudut.get(i).getPysty()<koko){ 
                ruudut.get(i+koko).setHidden(false);
                }
                if(i-koko-1>=0&&ruudut.get(i).getPysty()>=1&&ruudut.get(i).getVaaka()>1){
                ruudut.get(i-koko-1).setHidden(false);
                }
                if(i-koko+1>=0&&ruudut.get(i).getPysty()>=1&&ruudut.get(i).getVaaka()<koko){
                ruudut.get(i-koko+1).setHidden(false);
                }
                if(i+koko-1<koko*koko&&ruudut.get(i).getPysty()<koko&&ruudut.get(i).getVaaka()>1){ 
                ruudut.get(i+koko-1).setHidden(false);
                }
                if(i+koko+1<koko*koko&&ruudut.get(i).getPysty()<koko&&ruudut.get(i).getVaaka()<koko){
                ruudut.get(i+koko+1).setHidden(false);
                }
            }
        
    }
    }
   
    
   

    public void mouseMoved(MouseEvent e) {

        int koordX = e.getX();
        int koordY = e.getY();
        

      
    }
    
    

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
         int koordX = e.getX();
        int koordY = e.getY();


    }

    public void mouseClicked(MouseEvent e) {
        int koordX = e.getX();
        int koordY = e.getY();
        int hiiri = e.getButton();
        //System.out.println(asd);

                for(int i=0;i<ruudut.size();i++){
            if(koordX>ruudut.get(i).getX()&&koordX<ruudut.get(i).getX()+ruudunkoko
                    &&koordY>ruudut.get(i).getY()&&koordY<ruudut.get(i).getY()+ruudunkoko){
                if(hiiri==1){
               ruudut.get(i).setHidden(false);
              
                    //System.out.println(ruudut.get(i).getX()+" "+ruudut.get(i).getY());
                    System.out.println("vaaka: "+ruudut.get(i).getVaaka()+" pysty:"+ruudut.get(i).getPysty());
                    System.out.println("id: "+i);
                }else if(hiiri==3){
                    if(ruudut.get(i).isLippu()==false){
                    ruudut.get(i).setLippu(true);
                    }else{
                      ruudut.get(i).setLippu(false);  
                    }
                }
            }
        
        }     
              //System.out.println(koordX+" "+koordY);   
                 
            
            
        

    }

    public void mouseDragged(MouseEvent e) {
        int koordX = e.getX();
        int koordY = e.getY();

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
         int code = e.getKeyCode();

        
    }
}
