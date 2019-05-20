package com.mycompany.xmlinjava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        VezbaFakeId vezbaFakeId = new VezbaFakeId(1, 2, "nesto");
        VezbaFakeId vezbaFakeId2 = new VezbaFakeId(4, 6, "nista");
        File file = new File("proba.xml");
        VezbaFakeId[] v = {vezbaFakeId, vezbaFakeId2};
        
        //serialize our Java object into the XML String
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(v);
        System.out.println("serialize our Java object into the XML String - xml: " + xml);
        
        //serialize our Java object to the XML file
        xmlMapper.writeValue(file, v);
        
        //Deserialize From the XML File
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String xml3 = sb.toString();
        System.out.println("Deserialize From the XML File - xml3: " + xml3);
                
        //Deserialize From the XML String
        VezbaFakeId[] vezbaFakeId333 = xmlMapper.readValue(xml3, VezbaFakeId[].class);
        System.out.println("Objekti su:");
        for(VezbaFakeId vez: vezbaFakeId333){
            System.out.println(vez.getId()+" " +vez.getUserId()+" " +vez.getTitle());
        }
    }

    private static void assertNotNull(String xml) {
    }
}
