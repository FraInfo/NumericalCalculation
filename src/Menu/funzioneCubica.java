/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Francy
 */
public class funzioneCubica implements Funzione {
    double a, b, c, d;
    
    public funzioneCubica (double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    } 
    
    @Override
    public void draw(Canvas canvas, Color color) {
        Graphics g = canvas.getGraphics();
        g.setColor(color);
        
        int hW = canvas.getWidth() / 2;
        int hH = canvas.getHeight() / 2;
        
        for (double x = -hW; x < hW; x += .01){
            double y = calcola(x);
            
            g.drawLine(
                    (int) ( x + hW), 
                    (int) ( -y + hH), 
                    (int) (x + hW), 
                    (int) ( -y + hH)                   
            );                                    
        }       
    }

    @Override
    public double calcola(double x) {
        double res = (a * Math.pow(x, 3)) + (b * Math.pow(x, 2)) + (c * x) + d;
        return res;
    }
}