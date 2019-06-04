package com.mycompany.checkurlstatus.controller.eMailController;

import com.mycompany.checkurlstatus.controller.Controller;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

public class CheckWebSiteUrl {

    public static int isSiteLiveHttp(String input) {
        int responseCode = 0;
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) (new URL(input)).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            responseCode = conn.getResponseCode();
            conn.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ue) {

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return responseCode;
    }

    public static int isSiteLiveHttps(String input) {
        int responseCode = 0;
        HttpsURLConnection conn = null;
        try {
            conn = (HttpsURLConnection) (new URL(input)).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            responseCode = conn.getResponseCode();
            conn.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ue) {

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return responseCode;
    }



}
