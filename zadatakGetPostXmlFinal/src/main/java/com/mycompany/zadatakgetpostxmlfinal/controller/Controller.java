package com.mycompany.zadatakgetpostxmlfinal.controller;

import com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests.Descendants;
import com.mycompany.zadatakgetpostxmlfinal.Config;
import com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests.*;

public class Controller {

    public static String CSRF_NONCE = null;
    public static final String X_AUTH_TOKEN = "8F090804908A729F429FA648DD8B19BE5AEBF605B1727768843961D83C38E8FF";

    public static void startApp() {
        //load configuration or set a new one
        Config.loadConfigurations();

        //getting of csrf code
        CreateCsrf createCsrf = new CreateCsrf();
        CSRF_NONCE = createCsrf.getCsrfCode();
        System.out.println("CSRF je: " + CSRF_NONCE);

        //get all descendants
        Descendants descendants = new Descendants();
        descendants.getAllDescendants();

        //print tree of all descendants
        descendants.printAllDescedantsTree();

        if (CSRF_NONCE != null) {
            //getting of all properties
            System.out.println("Properties are: " + (new Properties().getAllProperties()));

            //getting of all absr   
            System.out.println("absr are: " + (new Absr().getAllAbsr()));

            //getting of all agvr   
            System.out.println("agvr are: " + (new Agvr().getAllAgvr()));

            //getting of all types
            System.out.println("all types are: " + (new AllTypes().getAllTypes()));

        } else {
            System.out.println("Error with getting of csrf");
        }
    }
}
