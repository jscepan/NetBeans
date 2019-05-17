package com.mycompany.getinjava;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {
//       HttpClient httpclient = new DefaultHttpClient();
        String user = "wcadmin";
        String password = "ptc";
        //String defaultUrlMaterials = "http://10.140.31.18/Windchill/servlet/rest/tm/types/com.lcs.wc.material.LCSMaterial/descendants";
        String defaultUrlMaterials = "http://10.140.31.18/Windchill/servlet/rest/tm/types/com.lcs.wc.product.LCSProduct/descendants";
        URL urlSite = new URL(defaultUrlMaterials /*+ "VR:com.lcs.wc.material.LCSMaterial:230993/colors"*/);
        HttpURLConnection con = (HttpURLConnection) urlSite.openConnection();
        con.setRequestMethod("GET");
            
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        user, password.toCharArray());
            }
        });
            
        con.setAuthenticator(Authenticator.getDefault());
        int responseCode = con.getResponseCode();
        System.out.println("Odgovor je:" + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            
            Items[] items = new Gson().fromJson(content.toString().substring(content.toString().indexOf(':') + 1, content.toString().length()).replaceAll(".$", ""), Items[].class);
            
//set first element as head of tree
            Items headItem = items[0];

//adding childs on parents list
            for (Items i : items) {
                if (i.getParentId() == null) {
                    headItem = i;
                    continue;
                }
                for (Items iGetId : items) {
                    if (i.getParentId().equals(iGetId.getId())) {
                        iGetId.childItemsList.add(i);
                        break;
                    }
                }
            }
            
// print of tree
            int increment = 5;
            for (Items i : items) {
                if (i.equals(headItem)) {
                    System.out.println("+ " + i.getDisplayName());
                    printList(i.childItemsList, increment);
                }
            }
        }
    }

    public static void printList(ArrayList<Items> list, int increment) {
        for (Items i : list) {
            printElement(i, increment);
        }
    }

    public static void printElement(Items items, int increment) {
        String incrementBlanks = "";
        for (int i = 0; i < increment; i++) {
            incrementBlanks += " ";
        }
        if (items.childItemsList.isEmpty()) {
            System.out.println(incrementBlanks + "-" + items.getDisplayName());
        } else {
            System.out.println(incrementBlanks + "+" + items.getDisplayName());
            printList(items.childItemsList, increment += increment);
        }
    }
}
