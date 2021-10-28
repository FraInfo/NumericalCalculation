/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author Francy
 */
public class TangentMethod {
    int maxIteration;
    float eps, delta;
    public Funzione funzione;
    
    public TangentMethod(int maxIteration, float eps, float delta, Funzione funzione){
        this.maxIteration = maxIteration;
        this.eps = eps;
        this.delta = delta;
        this.funzione = funzione;
    }
    
    public double Kt(double Xi){
        return (funzione.calcola(Xi + delta) - funzione.calcola(Xi)) / delta;
    }
    
    public double calcola(double a, double b){
        boolean end = false;        
        double fA, fB, Xi = 0, fI, Xold, sc;
        
        if (a > b) {
            sc = a; 
            a = b; 
            b = sc;
        }

        fA = funzione.calcola(a);
        fB = funzione.calcola(b);
        
        if (fA * fB >= 0) {
            System.out.println("intervallo non valido\n");
            return -1;
        }

        Xold = (a + b) * 0.5;
        
        for (int i = 0; i < maxIteration && !end; i++) {
            Xi = -funzione.calcola(Xold) / Kt(Xold) + Xold;
            fI = funzione.calcola(Xi);
            
            System.out.println(Xi);
            
            if ((Math.abs(Xi - Xold) < eps) || (fI == 0)) 
                end = true;
            else
                Xold = Xi;
        }
        
        if (end) {
            return Xi;
        } else {
            System.out.println("troppe iterazioni");
            return -1;
        }
    }        
}    