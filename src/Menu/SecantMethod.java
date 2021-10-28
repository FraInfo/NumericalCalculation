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
public class SecantMethod {
    int maxIteration;
    float eps;
    public Funzione funzione;
    
    public SecantMethod(int maxIteration, float eps, Funzione funzione){
        this.maxIteration = maxIteration;
        this.eps = eps;
        this.funzione = funzione;
    }
    
    public double Ks(double Xnew, double Xold){
        return (funzione.calcola(Xnew) - funzione.calcola(Xold)) / (Xnew - Xold);
    }
    
    public double calcola(double a, double b){
        boolean end = false;        
        double fA, fB, Xm = 0, fM, Xnew = 0, Xold, sc;
        
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
            Xm = -funzione.calcola(Xold) / Ks(Xnew, Xold) + Xold;
            fM = funzione.calcola(Xm);
            
            System.out.println(Xm);
            
            if ((Math.abs(Xm - Xold) < eps) || (fM == 0)) 
                end = true;
            else
                Xold = Xnew;
                Xnew = Xm;
        }
        
        if (end) {
            return Xm;
        } else {
            System.out.println("troppe iterazioni");
            return -1;
        }
    }        
}    