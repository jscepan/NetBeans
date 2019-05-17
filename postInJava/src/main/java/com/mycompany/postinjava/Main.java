package com.mycompany.postinjava;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String user = "wcadmin";
        String password = "ptc";

        final String POST_PARAMS ="";
//                "{\n" + "\"userId\": 101,\r\n"
//                + "    \"id\": 101,\r\n"
//                + "    \"title\": \"Test Title\",\r\n"
//                + "    \"body\": \"Test Body\"" + "\n}";
        System.out.println(POST_PARAMS);

        String defaultUrlMaterials = "http://10.140.31.18/Windchill/servlet/rest/tm/types/com.lcs.wc.material.LCSMaterial/descendants";
        URL urlSite = new URL(defaultUrlMaterials /*+ "VR:com.lcs.wc.material.LCSMaterial:230993/colors"*/);
        HttpURLConnection con = (HttpURLConnection) urlSite.openConnection();
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        user, password.toCharArray());
            }
        });
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        con.setAuthenticator(Authenticator.getDefault());
//        OutputStream os = con.getOutputStream();
//        os.write(POST_PARAMS.getBytes());
//        os.flush();
//        os.close();
        //       HttpClient httpclient = new DefaultHttpClient();
        int responseCode = con.getResponseCode();
        System.out.println("Odgovor je:" + responseCode);
        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            Items[] items = new Gson().fromJson(content.toString().substring(content.toString().indexOf(':') + 1, content.toString().length()).replaceAll(".$", ""), Items[].class);

            Items headItem = null;

//            
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

//set first element as head of tree
            if (headItem == null) {
                headItem = items[0];
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
