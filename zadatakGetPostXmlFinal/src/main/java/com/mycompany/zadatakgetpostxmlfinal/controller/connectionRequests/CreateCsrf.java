package com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.zadatakgetpostxmlfinal.model.csrf.CatalogCsrf;

public class CreateCsrf extends ConnectionToBase{
    private static final String URL_PART = "/security/csrf";

    public String getCsrfCode() {
        try {
            con = createConnection(URL_PART, "GET");
            int responseCode = con.getResponseCode();

            //geting answer and parsing of response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String response = readStringFromConnection(con);
                ObjectMapper mapper = new ObjectMapper();
                CatalogCsrf catalogCsrf = mapper.readValue(response, CatalogCsrf.class);
                return catalogCsrf.getItems().get(0).getAttributes().getNonce();
            }
        } catch (IOException ex) { 
            Logger.getLogger(CreateCsrf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
