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

        String defaultUrlMaterials = "https://jsonplaceholder.typicode.com/albums";

        URL urlSite = new URL(defaultUrlMaterials/*+ "VR:com.lcs.wc.material.LCSMaterial:230993/colors"*/); //Create A URL Object
        HttpURLConnection con = (HttpURLConnection) urlSite.openConnection(); //From the above URL object, we can invoke the openConnection method to get the HttpURLConnection object. We can’t instantiate HttpURLConnection directly, as it’s an abstract class
        con.setRequestMethod("POST"); //Set the Request Method
        con.setRequestProperty("Content-Type", "application/json; utf-8"); //This parameter has to be set to send the request body in JSON format.
        con.setRequestProperty("Accept", "application/json"); //Set the “Accept” request header to “application/json” to read the response in the desired format:
        con.setDoOutput(true); //Ensure the Connection Will Be Used to Send Content. Otherwise, we’ll not be able to write content to the connection output stream
        con.setDoInput(true);
        VezbaFakeId v = new VezbaFakeId(111, 111, "Scepan");
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(v); //After creating a custom JSON String:
        System.out.println("ovo se salje: " + jsonInputString);
        OutputStream os = con.getOutputStream(); //We’d need to write it
        byte[] input = jsonInputString.getBytes();
        os.write(input, 0, input.length);

        int responseCode = con.getResponseCode();
        System.out.println("Odgovor je:" + responseCode);
        if (responseCode == HttpURLConnection.HTTP_CREATED) {

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));//Read the Response from Input Stream
            String responseLine = null;
            StringBuilder response = new StringBuilder();
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
                System.out.println(response);
            }

//        Authenticator.setDefault(new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(
//                        user, password.toCharArray());
//            }
//        });
//

//            VezbaFakeId[] vezbaFakeId = new Gson().fromJson(content.toString(), VezbaFakeId[].class);
//            for (VezbaFakeId v: vezbaFakeId)
//            {
//                System.out.println(v);
//            }

                /*
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
    }*/
            }
        }
    }
