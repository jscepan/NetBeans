package com.mycompany.mavenproject3;
public class MacOsFactory implements ButtonFactory {

    @Override
    public Button createButton() {
        System.out.println("creating mac button");
        return new MacButton();
    }
    
}
