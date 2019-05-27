package com.mycompany.zadatak2.assignmentController;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private final static File FILE_CONFIG = new File("config.xml");
    public static Config config;
    private String userName;
    private String password;
    private String url;

    public Config() {
    }

    public Config(String userName, String password, String url) {
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

    @Override
    public String toString() {
        return "Config{" + "userName=" + userName + ", password=" + password + ", url=" + url + '}';
    }



    public static void loadConfigurations() {
        if (FILE_CONFIG.exists()) {
            importFromFile();
        } else {
            createFile();
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Uneti ime");
        String nameVar = sc.nextLine();
        System.out.println("Uneti password:");
        String passVar = sc.nextLine();
        System.out.println("Uneti url:");
        String urlVar = sc.nextLine();

        config = new Config(nameVar, passVar, urlVar);
//serialize our Java object to the XML file
        try {
            XmlMapper xmlMapper = new XmlMapper();
            config.password = encodeInBase64(config.password);
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
