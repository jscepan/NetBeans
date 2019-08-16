package com.mycompany.mavenproject31;

public class Main {

    public static void main(String[] args) {
        Zaposleni m1 = new Menadzer("Mika1");
        Zaposleni m2 = new Menadzer("Mika2");
        Zaposleni m3 = new Menadzer("Mika3");
        Zaposleni m4 = new Menadzer("Mika4");
        Programer p1 = new Programer("Pera1");
        Programer p2 = new Programer("Pera2");
        Programer p3 = new Programer("Pera3");
        Programer p4 = new Programer("Pera4");
        m1.dodaj(m2);
        m2.dodaj(p1);
        m3.dodaj(p4);
        m3.dodaj(m2);
        m1.dodaj(m4);
        m4.dodaj(p4);
        m2.dodaj(p2);
        m1.dodaj(p3);
        
        System.out.println(m3);
    }
}
