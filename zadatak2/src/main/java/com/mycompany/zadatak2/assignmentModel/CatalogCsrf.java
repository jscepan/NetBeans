package com.mycompany.zadatak2.assignmentModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogCsrf {

    private List<Csrf> items;
    static Config config;

    public CatalogCsrf() {
    }

    public CatalogCsrf(List<Csrf> items) {
        this.items = items;
    }

    public List<Csrf> getItems() {
        return items;
    }

    public void setItems(List<Csrf> items) {
        this.items = items;
    }

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config config) {
        CatalogCsrf.config = config;
    }

    public static String getCsrfCode() {
        try {
            config = Config.loadConfigurations();
            HttpURLConnection con = ConnectionToBase.createConnection(config.getUrl() + "/security/csrf", "GET");
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
        return "greska";
    }

    @Override
    public String toString() {
        return "CatalogCsrf{" + "items=" + items + '}';
    }
}
