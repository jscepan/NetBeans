package com.mycompany.zadatak2.assignmentController;

import com.mycompany.zadatak2.assignmentModel.Descendants;
import com.mycompany.zadatak2.assignmentModel.csrf.CatalogCsrf;
import com.mycompany.zadatak2.assignmentModel.Properties;
import com.mycompany.zadatak2.assignmentModel.Absr;
import com.mycompany.zadatak2.assignmentModel.Agvr;
import com.mycompany.zadatak2.assignmentModel.CatalogTypes;
import com.mycompany.zadatak2.assignmentModel.ViewForType;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Config config;
    private static URL urlSite;
    private static HttpURLConnection con;
    private static String CSRF_NONCE = "";
    private static final String X_AUTH_TOKEN = "8F090804908A729F429FA648DD8B19BE5AEBF605B1727768843961D83C38E8FF";

    public static void startApp() {
        //load configuration or set a new one
        Config.loadConfigurations();

//getting of csrf code
        CSRF_NONCE = CatalogCsrf.getCsrfCode();
        System.out.println("CSRF je: " + CSRF_NONCE);

        Descendants.getAllDescendants();
        Descendants.printAllDescedantsTree(Descendants.getListOfItemsArray());
// send POST requests for absr, agvr, properties, types            

        if (CSRF_NONCE != null) {

//Properties  
System.out.println("Properties");
            List<String> propertiesForPost = new ArrayList<>();
            propertiesForPost.add("com.lcs.wc.flexbom.FlexBOMLink.designBomCommentsKey");
            propertiesForPost.add("com.lcs.wc.color.isCMYKEnabled");
            propertiesForPost.add("com.lcs.wc.color.cmyk.InternalKeyForC");
            propertiesForPost.add("com.lcs.wc.color.cmyk.InternalKeyForM");
            propertiesForPost.add("com.lcs.wc.color.cmyk.InternalKeyForY");
            propertiesForPost.add("com.lcs.wc.color.cmyk.InternalKeyForK");
            propertiesForPost.add("com.lcs.wc.color.cmyk.InternalKeyForIsCMYK");
            
            String x = ViewForType.postForProperties(Properties.PART_URL, propertiesForPost, "CSRF_NONCE", CSRF_NONCE, "X-Auth-Token", X_AUTH_TOKEN, "Content-Type", "application/json", "Accept", "application/json");
            if (x != null) {
                System.out.println(x);
            } else {
                System.out.println("Error in getting of properties");
            }

//absr   
System.out.println("absr");
            List<String> absrForPost = new ArrayList<>();
            for (CatalogTypes ct : Descendants.getListOfItemsArray()) {
                absrForPost.add((ct.getItems().get(0).getId()));
            }

            String y = ViewForType.postForProperties(Absr.PART_URL, absrForPost, "CSRF_NONCE", CSRF_NONCE, "X-Auth-Token", X_AUTH_TOKEN, "Content-Type", "application/json", "Accept", "application/json");
            if (y != null) {
                System.out.println(y);
            } else {
                System.out.println("Error in getting of absr");
            }

//agvr
System.out.println("agvr");
            List<String> allTypesForPost = new ArrayList<>();
            for (int i = 0; i < Descendants.getListOfItemsArray().size(); i++) {
                for (int j = 0; j < Descendants.getListOfItemsArray().get(i).getItems().size(); j++) {
                    allTypesForPost.add(Descendants.getListOfItemsArray().get(i).getItems().get(j).getId());
                }
            }
            String z = ViewForType.postForProperties(Agvr.PART_URL, allTypesForPost, "CSRF_NONCE", CSRF_NONCE, "X-Auth-Token", X_AUTH_TOKEN, "Content-Type", "application/json", "Accept", "application/json");
            if (z != null) {
                System.out.println(z);
            } else {
                System.out.println("Error in getting of agvr");
            }
//types
System.out.println("types");
            String q = ViewForType.postForProperties(CatalogTypes.PART_URL, allTypesForPost, "CSRF_NONCE", CSRF_NONCE, "X-Auth-Token", X_AUTH_TOKEN, "Content-Type", "application/json", "Accept", "application/json");
            if (q != null) {
                System.out.println(q);
            } else {
                System.out.println("Error in getting of types");
            }

        } else {
            System.out.println("Error with getting of csrf");
        }
    }
}
