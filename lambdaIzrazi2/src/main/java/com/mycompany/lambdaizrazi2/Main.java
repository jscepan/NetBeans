package com.mycompany.lambdaizrazi2;

public class Main {

    public static void main(String[] args) {
        //prvi nacin sa extends Thread
        Runnable n = new Nit();

        //drugi nacin sa implements runnable
        Nit2 n2 = new Nit2();
        Thread t = new Thread(n2);
        t.start();
        //a moze da se pise i ovako:     new Thread(n2).start();
        new Thread(() -> System.out.println("hello")).start();
    }
}
