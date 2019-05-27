package com.mycompany.zadatak2.assignmentModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.mycompany.zadatak2.assignmentModel.ConnectionToBase.con;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewForType extends ConnectionToBase {

    private List<String> ids;

    public ViewForType() {
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public ViewForType(List<String> ids) {
        this.ids = ids;
    }


    public static String postForProperties(String partOfUrl, List<String> listInput, String... property) {
        ObjectMapper mapper = new ObjectMapper();
        String response = null;
        String propertiesForPost = null;
        try {
            propertiesForPost = mapper.writeValueAsString(new ViewForType(listInput));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ViewForType.class.getName()).log(Level.SEVERE, null, ex);
        }

        int responseCode;
        try {
// creating of new connection by sending url, method, array of requestProperties
            con = ConnectionToBase.createConnection(partOfUrl, "POST", property);
            byte[] input = propertiesForPost.getBytes();
            try ( DataOutputStream os = new DataOutputStream(con.getOutputStream());) {
                os.write(input, 0, input.length);
            }
            responseCode = con.getResponseCode();
//geting answer and parsing of response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                response = ConnectionToBase.readStringFromConnection(con);
            }
        } catch (IOException ex) {
            Logger.getLogger(Descendants.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}
