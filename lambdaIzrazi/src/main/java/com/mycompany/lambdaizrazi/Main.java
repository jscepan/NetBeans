package com.mycompany.lambdaizrazi;

public class Main {
    
    public static void main(String[] args) {
        //standardan pristup
        NekiInterfejs k = new KlasaOdInterfejsa();
        k.metoda();

        //lambda izraz i moguc je jer postoji samo jedna metoda u interfejsu
        //gde ide         metodini argumenti      funkcija
        NekiInterfejs k2 = () -> System.out.println("Neki ispis...");
        k2.metoda();
        
        SabiranjeDvaBroja s = new Saberi();
        System.out.println(s.saberi(3, 4));
        
        SabiranjeDvaBroja s2 = (x, y) -> x + y;
        System.out.println(s2.saberi(5, 9));
        
        s2 = (x, y) -> x - y;
        System.out.println(s2.saberi(5, 9));

        //dodajem default metodu u sabiranje dva broja
        s2 = (a, b) -> a * a + b * b;
        System.out.println(s2.poziv(3, 7));
    }
    
}
