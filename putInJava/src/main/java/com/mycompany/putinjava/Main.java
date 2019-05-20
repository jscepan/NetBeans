package com.mycompany.putinjava;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String defaultUrlMaterials = "https://jsonplaceholder.typicode.com/albums/1";

        URL urlSite = new URL(defaultUrlMaterials/*+ "VR:com.lcs.wc.material.LCSMaterial:230993/colors"*/); //Create A URL Object
        HttpURLConnection con = (HttpURLConnection) urlSite.openConnection(); //From the above URL object, we can invoke the openConnection method to get the HttpURLConnection object. We can’t instantiate HttpURLConnection directly, as it’s an abstract class
        con.setRequestMethod("PUT"); //Set the Request Method
        con.setRequestProperty("Content-Type", "application/json; utf-8"); //This parameter has to be set to send the request body in JSON format.
        con.setRequestProperty("Accept", "application/json"); //Set the “Accept” request header to “application/json” to read the response in the desired format:
        con.setDoOutput(true); //Ensure the Connection Will Be Used to Send Content. Otherwise, we’ll not be able to write content to the connection output stream
        con.setDoInput(true);
        VezbaFakeId v = new VezbaFakeId(101, 111, "Scepan");
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(v); //After creating a custom JSON String:
        System.out.println("ovo se salje: " + jsonInputString);
        OutputStream os = con.getOutputStream(); //We’d need to write it
        byte[] input = jsonInputString.getBytes();
        os.write(input, 0, input.length);

        int responseCode = con.getResponseCode();
        System.out.println("Odgovor je:" + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));//Read the Response from Input Stream
            String responseLine = null;
            StringBuilder response = new StringBuilder();
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
                System.out.println(response);
            }

        }

    }
}
