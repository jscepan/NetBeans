package com.mycompany.lambdaizrazi2;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LambdaGUI extends Frame {

    Button b;
    Panel p;

    public LambdaGUI() {
        b = new Button("Klik");
        p = new Panel();
        p.add(b);
        add(p);
        setSize(new Dimension(300, 300));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        //moze ovako. Uz ovo ide klasa iz napomene odozdo
//        b.addActionListener(new Osluskivac());
        
        //ovako je manji zapis
        b.addActionListener((e) -> {
            System.out.println("klik...");
        });
        
        
        
        
        
        
    }
//class Osluskivac implements ActionListener {
//
//    @Override
//    public void actionPerformed(ActionEvent arg0) {
//        System.out.println("ispis posle klika...");
//    }
// 
    
    
    
    
    
    //adapter je klasa izmedju interfejsa i klasa. Sve kako ne moraju da se implementiraju sve metode interfejsa
    public static void main(String[] args) {
        new LambdaGUI().setVisible(true);
    }
private class Osluskivac implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("ispis posle klika...");
    }
}

   
}
