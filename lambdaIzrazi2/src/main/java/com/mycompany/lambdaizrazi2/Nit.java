package com.mycompany.lambdaizrazi2;

public class Nit extends Thread {

    public Nit() {
        start();
        
    }

    @Override
    public void run() {
        System.out.println("krece nit1");
    }

}
