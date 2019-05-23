package com.mycompany.zadatak2.assignmentController;

import com.mycompany.zadatak2.assignmentModel.Config;
import com.mycompany.zadatak2.assignmentModel.Descendants;
import com.mycompany.zadatak2.assignmentModel.CatalogCsrf;
import com.mycompany.zadatak2.assignmentModel.Properties;
import com.mycompany.zadatak2.assignmentModel.Absr;
import com.mycompany.zadatak2.assignmentModel.CatalogTypes;
import com.mycompany.zadatak2.assignmentModel.Types;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Config config;
    private static URL urlSite;
    private static HttpURLConnection con;
    private static List<Types> allIdTypes = new ArrayList<>();
    private static String CSRF_NONCE = "";
    private static String xAuthToken = "8F090804908A729F429FA648DD8B19BE5AEBF605B1727768843961D83C38E8FF";
    private static int responseCode;

    public static void startApp() {

//load configuration or set a new one
        Config.loadConfigurations();

//getting of csrf code
        CSRF_NONCE = CatalogCsrf.getCsrfCode();

        System.out.println("CSRF je: " + CSRF_NONCE);

        Descendants.getAllDescendants();

        Descendants.printAllDescedantsTree(Descendants.getListOfItemsArray());
// send POST requests for absr, agvr, properties, types            

        String properties = Properties.postForProperties("CSRF_NONCE", CSRF_NONCE, "X-Auth-Token", xAuthToken, "Content-Type", "application/json", "Accept", "application/json");

        for(CatalogTypes ct: Descendants.getListOfItemsArray()){
            System.out.println((ct.getItems().get(0).getId()));
        }
        
        
        //String absr = Absr.postForAbsr("CSRF_NONCE", CSRF_NONCE, "X-Auth-Token", xAuthToken, "Content-Type", "application/json", "Accept", "application/json");

    }

}
