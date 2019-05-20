package com.mycompany.zadatak;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private final static File FILE_CONFIG = new File("config.xml");
    private String name;
    private String username;
    private String password;
    private static Config config;

    public Config(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config config) {
        Config.config = config;
    }

    public Config() {
    }

    public static Config createConfigFail() {
        if (FILE_CONFIG.exists()) {
            System.out.println("Fajl postoji");
            importFromFile();
        } else {
            System.out.println("Fajl ne postoji");
            createFile();
        }
        return config;
    }

    private static void createFile() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Uneti ime");
        String nameVar = "ss";//sc.nextLine();
//        System.out.println("Uneti password:");
        String passVar = "dd";//sc.nextLine();
//        System.out.println("Uneti url:");
        String urlVar = "ff";//sc.nextLine();
        config = new Config(nameVar, passVar, urlVar);
        System.out.println("kreiram config sa: n: " + config.name + " p: " + config.password + " u: " + config.username);

        try {
            //serialize our Java object into the XML String
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(config);

            String probaFormatiran = Base64.getEncoder().encodeToString(xml.getBytes());

            //serialize our Java object to the XML file
            xmlMapper.writeValue(FILE_CONFIG, probaFormatiran);
        } catch (IOException e) {
            e.getMessage();
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
            XmlMapper xmlMapper = new XmlMapper();
            Config config = xmlMapper.readValue(xml3, Config.class);

//            byte[] probaDecoding = Base64.getDecoder().decode(config);
//            String probaVracen = new String(probaDecoding);
            
            System.out.println("ucitano je iz fajla: n: " + config.name + " p: " + config.password + " u: " + config.username);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
