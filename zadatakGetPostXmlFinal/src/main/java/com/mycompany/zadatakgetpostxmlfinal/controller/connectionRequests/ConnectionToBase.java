package com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.zadatakgetpostxmlfinal.Config;
import com.mycompany.zadatakgetpostxmlfinal.controller.Controller;
import com.mycompany.zadatakgetpostxmlfinal.model.ViewForType;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionToBase {

    private static URL urlSite;
    public HttpURLConnection con;

    public ConnectionToBase() {
    }

    public ConnectionToBase(HttpURLConnection con) {
        this.con = con;
    }

    public static URL getUrlSite() {
        return urlSite;
    }

    public static void setUrlSite(URL urlSite) {
        ConnectionToBase.urlSite = urlSite;
    }

    public HttpURLConnection getCon() {
        return con;
    }

    public void setCon(HttpURLConnection con) {
        this.con = con;
    }

    public HttpURLConnection createConnection(String url, String method, String... property) {

        try {
            urlSite = new URL(Config.url + url);
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            Config.userName, (Config.decodeInBase64(Config.password)).toCharArray());
                }
            });

            con = (HttpURLConnection) urlSite.openConnection();
            con.setRequestMethod(method);
            con.setDoOutput(true);
            con.setDoInput(true);
            for (int i = 0; i < (property.length - 1); i += 2) {
                con.setRequestProperty(property[i], property[i + 1]);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex+" nit:"+Thread.currentThread().getId());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public String readStringFromConnection(HttpURLConnection con) {
        String response = null;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            response = content.toString();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return response;
    }

    public String postMethodForSomeType(String partOfUrl, List<String> listInput) {
        ObjectMapper mapper = new ObjectMapper();
        String response = null;
        String textForPost = null;
        int responseCode;
        try {
            //converting of getting list to Json String
            textForPost = mapper.writeValueAsString(new ViewForType(listInput));
            
            // creating of new connection by sending url, method, array of requestProperties
            con = createConnection(partOfUrl, "POST", "CSRF_NONCE", Controller.CSRF_NONCE, "X-Auth-Token", Controller.X_AUTH_TOKEN, "Content-Type", "application/json", "Accept", "application/json");
            byte[] input = textForPost.getBytes();
            try ( DataOutputStream os = new DataOutputStream(con.getOutputStream());) {
                os.write(input, 0, input.length);
            } 
            responseCode = con.getResponseCode();
            
            //geting answer and parsing of response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                response = readStringFromConnection(con);
            }
            
        } catch (JsonProcessingException ex) { 
            Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}
