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
public class BisectionMethod {
    int maxIteration;
    float eps;
    public Funzione funzione;
    
    public BisectionMethod(int maxIteration, float eps, Funzione funzione){
        this.maxIteration = maxIteration;
        this.eps = eps;
        this.funzione = funzione;
    }
    
    public double calcola(double a, double b){
        boolean end = false;
        double Xa = 0, Xb = 0, fA = 0, fB = 0, Xm = 0, fM = 0, sc = 0;
        
        if (a > b){
            sc = a;
            a = b;
            b = sc;
        }
        
        fA = funzione.calcola(a);
        fB = funzione.calcola(b);
        
        if (fA * fB > 0){
            System.out.println("Intervallo non valido");
            return -1;              
        } else {
            Xa = a;
            Xb = b;
        }
        
            for (int i = 0; i < maxIteration && !end; i++){
                fA = funzione.calcola(Xa); 
                fB = funzione.calcola(Xb);

                Xm = (Xa + Xb) * 0.5;
                fM = funzione.calcola(Xm);

                if (fM * fA >= 0)
                    Xa = Xm;

                if (Xa != Xm)
                    Xb = Xm;

                if (Math.abs(Xb - Xa) < eps || (fM == 0))
                    end = true;
            }     
        if (end){
            return Xm;
        } else {
            System.out.println("Aumenta iterazioni");
            return -1;
        }
    }       
}    