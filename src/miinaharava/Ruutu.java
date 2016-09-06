
package miinaharava;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;


public class Ruutu {
    
    int x, y;
    boolean miina;
    boolean lippu;
    boolean hidden=true;
    int numero;
    int vaaka;
    int pysty;
    
 
    public Ruutu(){
 
    }

    public Ruutu(int x, int y, boolean miina,int vaaka, int pysty) {
        this.x = x;
        this.y = y;
        this.miina = miina;
        this.vaaka = vaaka;
        this.pysty = pysty;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMiina() {
        return miina;
    }

    public void setMiina(boolean miina) {
        this.miina = miina;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isLippu() {
        return lippu;
    }

    public void setLippu(boolean lippu) {
        this.lippu = lippu;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVaaka() {
        return vaaka;
    }

    public void setVaaka(int vaaka) {
        this.vaaka = vaaka;
    }

    public int getPysty() {
        return pysty;
    }

    public void setPysty(int pysty) {
        this.pysty = pysty;
    }
    
    

    
    
    
    
    
    
    
}

