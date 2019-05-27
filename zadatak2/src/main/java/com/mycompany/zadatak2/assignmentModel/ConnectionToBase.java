package com.mycompany.zadatak2.assignmentModel;

import com.mycompany.zadatak2.assignmentController.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionToBase {

    private static URL urlSite;
    public static HttpURLConnection con;

    public static HttpURLConnection createConnection(String url, String method, String... property) {

        try {
            urlSite = new URL(Config.config.getUrl() + url);
            con = (HttpURLConnection) urlSite.openConnection();
            con.setRequestMethod(method);
            for (int i = 0; i < (property.length - 1); i += 2) {
                con.setRequestProperty(property[i], property[i + 1]);
            }
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            Config.config.getUserName(), (Config.decodeInBase64(Config.config.getPassword())).toCharArray());
                }
            });
            con.setDoOutput(true); //Ensure the Connection Will Be Used to Send Content. Otherwise, we’ll not be able to write content to the connection output stream
            con.setDoInput(true);
            con.setAuthenticator(Authenticator.getDefault());
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static String readStringFromConnection(HttpURLConnection con) {
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
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionToBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return response;
    }
}
