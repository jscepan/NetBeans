package com.mycompany.zadatak2.assignmentModel.csrf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.zadatak2.assignmentModel.ConnectionToBase;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogCsrf extends ConnectionToBase {

    private List<Csrf> items;
    private static final String URL_PART ="/security/csrf";
//    static Config config;

    public CatalogCsrf(List<Csrf> items) {
        this.items = items;
    }

    public CatalogCsrf() {
    }

    public List<Csrf> getItems() {
        return items;
    }

    public void setItems(List<Csrf> items) {
        this.items = items;
    }

    public static String getCsrfCode() {
        try {
            con = ConnectionToBase.createConnection(URL_PART, "GET");
            int responseCode = con.getResponseCode();

//geting answer and parsing of response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String response = ConnectionToBase.readStringFromConnection(con);
                ObjectMapper mapper = new ObjectMapper();
                CatalogCsrf it = mapper.readValue(response, CatalogCsrf.class);
                return it.items.get(0).getAttributes().getNonce();
            }
        } catch (IOException ex) {
            Logger.getLogger(Csrf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "CatalogCsrf{" + "items=" + items + '}';
    }
}
