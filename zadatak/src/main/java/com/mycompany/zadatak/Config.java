package com.mycompany.zadatak;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private final static File FILE_CONFIG = new File("config.xml");
    private static Config config;
    private static User user;
    private static URL url;

    private Config() {
    }

    private Config(User user, URL url) {
        this.user = user;
        this.url = url;
    }

    public static void loadConfigurations() {
        if (FILE_CONFIG.exists()) {
            System.out.println("Fajl postoji");
            importFromFile();
        } else {
            System.out.println("Fajl ne postoji");
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
            System.out.println(xml3);

            //Deserialize From the XML String
            XmlMapper xmlMapper = new XmlMapper();
            user = xmlMapper.readValue(xml3, User.class);
            System.out.println("ucitano je iz fajla: u: " + config.user.getUsername() + " p: " + config.user.getPassword());

            //create new configuration
            config = new Config(user, url);
            System.out.println("kreiracu config sa: username: " + config.user.getUsername() + ", password: " + config.user.getPassword() + ", a url je: " + url);
            System.out.println(user.getUsername() + " " + user.getPassword());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void createFile() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Uneti ime");
        String nameVar = "ss";//sc.nextLine();
//        System.out.println("Uneti password:");
        String passVar = "dd";//sc.nextLine();
//        System.out.println("Uneti url:");
        String urlVar = "ff";//sc.nextLine();

        //create user and file url
        user = new User(nameVar, passVar);
        try {
            url = new URL(urlVar);
        } catch (MalformedURLException ex) {
            ex.getMessage();
        }

        //create new configuration
        config = new Config(user, url);
        System.out.println("kreiracu config sa: username: " + config.user.getUsername() + ", password: " + config.user.getPassword() + ", a url je: " + urlVar);

        try {
            //serialize our Java object into the XML String
            XmlMapper xmlMapper = new XmlMapper();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            System.out.println("ovde");
            xmlMapper.writeValue(byteArrayOutputStream, config);
            System.out.println("sad ovde");
            //       String xml = xmlMapper.writeValueAsString(config);

            System.out.println("ovde stigao");
            //     System.out.println("serialize our Java object into the XML String - xml: " + xml);

//            //serialize our Java object to the XML file
//            XmlMapper xmlMapper = new XmlMapper();
//            xmlMapper.writeValue(FILE_CONFIG, config);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String encodeInBase64(String string) {
        //coding of string
        String stringFormatted = Base64.getEncoder().encodeToString(string.getBytes());
        System.out.println("Tekst u base64: " + stringFormatted);
        return stringFormatted;
    }

    private static String decodeInBase64(String string) {
        //decoding of string
        byte[] varDecoding = Base64.getDecoder().decode(string);
        String varDecoded = new String(varDecoding);
        System.out.println("Tekst vracen: " + varDecoded);
        return varDecoded;
    }
}
