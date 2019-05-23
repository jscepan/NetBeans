package com.mycompany.zadatak2.assignmentModel;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Properties {

    private static Config config;

    public static String postForProperties(String... properties) {
        String response = null;
        String propertiesForPost = "{\n"
                + "    \"ids\": [\n"
                + "        \"com.lcs.wc.flexbom.FlexBOMLink.designBomCommentsKey\",\n"
                + "        \"com.lcs.wc.color.isCMYKEnabled\",\n"
                + "        \"com.lcs.wc.color.cmyk.InternalKeyForC\",\n"
                + "        \"com.lcs.wc.color.cmyk.InternalKeyForM\",\n"
                + "        \"com.lcs.wc.color.cmyk.InternalKeyForY\",\n"
                + "        \"com.lcs.wc.color.cmyk.InternalKeyForK\",\n"
                + "        \"com.lcs.wc.color.cmyk.InternalKeyForIsCMYK\"\n"
                + "    ]\n"
                + "}";

        int responseCode;
        try {
            config = Config.loadConfigurations();
// creating of new connection by sending url, method, array of requestProperties
            HttpURLConnection con = ConnectionToBase.createConnection(config.getUrl() + "/p76/types/properties", "POST", properties);

            byte[] input = propertiesForPost.getBytes();
            try ( DataOutputStream os = new DataOutputStream(con.getOutputStream());) { //Write it
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
