package com.mycompany.mavenproject3;
public class WindowsFactory implements ButtonFactory{

    @Override
    public Button createButton() {
        System.out.println("creating win button");
        return new WindowsButton();
    }
    
}
