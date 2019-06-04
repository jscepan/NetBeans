package com.mycompany.paket2;

public class GlavnaKlasa {

    public static void main(String[] args) {
        Gama g = new Gama();
        
        
        Fun f = x -> g.m3(x); //umesto tela poziva se druga metoda
        double a = f.fun(7);

        System.out.println(a);
        
        //  g-objekat Gama  m-funkcija objekta gama
        f = g::m3; //skraceni zapis prethodnog
        a = f.fun(7);
        System.out.println(a);
    }
}
