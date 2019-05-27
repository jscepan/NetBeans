package com.mycompany.mavenproject31;

public class Main {

    static int i = 0;
    static int j = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.println(i + "" + j + "" + k);
                }
            }
        }

        int suma = 0;
        int y = 5;

        for (int i = 1; i < y + 1; i++) {
            suma += i;
        }
        System.out.println(suma);
        poziv();
        ispisBrojeva();
        System.out.println("a sad ovo");
        poziv3(3);
    }

    public static void poziv() {
        i++;
        System.out.println("U metodi poziv..." + i);
        if (i < 3) {
            poziv();
        }
        System.out.println("U povratku..." + i--);
    }

    public static void ispisBrojeva() {
        j++;
        System.out.print(j);
        if (j<3)
        ispisBrojeva();
        System.out.print(j--);
    }
    public static void poziv3(int n){
        System.out.println(n);
        if (n>0) poziv3 (n-1);
        System.out.println(n);
    }
}
