package com.mycompany.checkurlstatus.controller.eMailController;

import com.mycompany.checkurlstatus.model.Email;
import com.mycompany.checkurlstatus.model.WebSite;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogEmail {

    List<Email> listOfEmail;
    static List<WebSite> listOfWebSite = new ArrayList<>();

    public CatalogEmail() {
    }

    public CatalogEmail(List<Email> listOfEmail) {
        this.listOfEmail = listOfEmail;
    }

    public List<Email> getListOfEmail() {
        return listOfEmail;
    }

    public void setListOfEmail(List<Email> listOfEmail) {
        this.listOfEmail = listOfEmail;
    }

    @Override
    public String toString() {
        return "CatalogEmail{" + "listOfEmail=" + listOfEmail + '}';
    }

    public List getWebStatusFromEmails() {
        Thread[] threads = new Thread[listOfEmail.size()];

        for (int i = 0; i < listOfEmail.size(); i++) {
            CatalogEmailThread cet = new CatalogEmailThread(listOfEmail.get(i));
            threads[i] = new Thread(cet);
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                if (t.isAlive()) {
                    t.join();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(CatalogEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listOfWebSite;
    }

    public static String convertEmailToWebUrl(String inputUrlEMail) {
        String parsedString = (inputUrlEMail.split("@")[1]);
        String urlWebSite = "http://www." + parsedString + "/";
        return urlWebSite;
    }

    public static WebSite isSiteLiveHttpAndCreateWebSite(Email email) {
        int responseCode = 0;
        HttpURLConnection conn = null;
        WebSite webSite = null;
        String urlWebSite = convertEmailToWebUrl(email.getEmail());
        try {
            conn = (HttpURLConnection) (new URL(urlWebSite)).openConnection();
            conn.setReadTimeout(8000);
            conn.setConnectTimeout(8000);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            responseCode = conn.getResponseCode();

            if (responseCode >= 300 && responseCode < 400) {
                String header = conn.getHeaderField("Location");
                webSite = new WebSite(email, urlWebSite, responseCode, header);
                conn.disconnect();
                return webSite;
            }
            conn.disconnect();

        } catch (java.net.SocketTimeoutException e) {
        } catch (MalformedURLException ex) {
        } catch (UnknownHostException ue) {
        } catch (IOException ex) {
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        webSite = new WebSite(email, urlWebSite, responseCode);
        return webSite;
    }
}
