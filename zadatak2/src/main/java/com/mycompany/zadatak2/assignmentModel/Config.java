package com.mycompany.zadatak2.assignmentModel;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private final static File FILE_CONFIG = new File("config.xml");
    private static Config config;
    private String userName;
    private String password;
    private String url;

    private Config() {
    }

    private Config(String userName, String password, String url) {
        this.userName = userName;
        this.password = password;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Config loadConfigurations() {
        if (FILE_CONFIG.exists()) {
            importFromFile();
            return config;
        } else {
            createFile();
            return config;
        }
    }

    private static void importFromFile() {
//Deserialize From the XML File
        StringBuilder sb = new StringBuilder();
        String line;
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_CONFIG)));) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String xml3 = sb.toString();

//Deserialize From the XML String
            XmlMapper xmlMapper = new XmlMapper();
            config = xmlMapper.readValue(xml3, Config.class);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createFile() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Uneti ime");
        String nameVar = "wcadmin";//sc.nextLine();
//        System.out.println("Uneti password:");
        String passVar = "ptc";//sc.nextLine();
//        System.out.println("Uneti url:");
        String urlVar = "http://10.140.31.18/Windchill/servlet/rest";//sc.nextLine();

        config = new Config(nameVar, passVar, urlVar);
//serialize our Java object to the XML file
        try {
            XmlMapper xmlMapper = new XmlMapper();
            config.password=encodeInBase64(config.password);
            xmlMapper.writeValue(FILE_CONFIG, config);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String encodeInBase64(String string) {
//coding of string
        String stringFormatted = Base64.getEncoder().encodeToString(string.getBytes());
        return stringFormatted;
    }

    public static String decodeInBase64(String string) {
//decoding of string
        byte[] varDecoding = Base64.getDecoder().decode(string);
        String varDecoded = new String(varDecoding);
        return varDecoded;
    }
}
