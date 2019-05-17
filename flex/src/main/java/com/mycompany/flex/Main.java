package com.mycompany.flex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
//        while (true) {
//            try ( ServerSocket sServer = new ServerSocket(2500);  Socket cn = sServer.accept();  BufferedReader br = new BufferedReader(new InputStreamReader(cn.getInputStream()));  BufferedOutputStream bos = new BufferedOutputStream(cn.getOutputStream());) {
//                FileInputStream fs = new FileInputStream("index.html");
//                String req = br.readLine();
//                int readByte = 0;
//                if ((req.split(" ")[1].replace("/", "")).equalsIgnoreCase("index.html")) {
//                    System.out.println("usao u prvi if");
//                while ((readByte = fs.read()) != -1) {
//                    bos.write((byte) readByte);
//                }
//                }

//
//                if ((req.split(" ")[1].replace("/", "")).equalsIgnoreCase("index.html")) {
//                    System.out.println("usao u prvi if");
//                    while ((readByte = fs.read()) != -1) {
//                        bos.write((byte) readByte);
//                    }
//                } else if (reqPage.split(" ")[0].split(".png")[0].equalsIgnoreCase("mapa_sa_gradovima")) {
//                    fs = new FileInputStream("mapa_sa_gradovima.png");
//                    while ((readByte = fs.read()) != -1) {
//                        bos.write((byte) readByte);
//                    }
//                }
//            }
        /*
// JSon u Javu
        try ( Reader reader = new FileReader("result.json");  Writer writer = new FileWriter("output.json")) {
//            java.lang.reflect.Type foundListType = new TypeToken<ArrayList<Items>>(){}.getType();
//            List<Items>items = new Gson().fromJson(reader, foundListType);
            Items[] items = new Gson().fromJson(reader, Items[].class);
//Java u JSon
            Gson gson = new Gson();
            writer.write(gson.toJson(items[0]));
//                    System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
// JSon u Javu sa iskljucivanjem null vrednosti


        
        
        
        
        
        
        
        
        
        try ( Reader reader = new FileReader("result.json");  Writer writer = new FileWriter("output.json")) {
//            java.lang.reflect.Type foundListType = new TypeToken<ArrayList<Items>>(){}.getType();
//            List<Items>items = new Gson().fromJson(reader, foundListType);
            Items[] items = new Gson().fromJson(reader, Items[].class);
//Java u JSon
            Gson gson = new Gson();
//            Gson gson = new GsonBuilder().serializeNulls().create();

//                            writer.write(gson.toJson(new GsonBuilder().));
//                    System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
//    }
//}

//        try ( Reader reader = new FileReader("text.json")) {
//            Founder[] founders = new Gson().fromJson(reader, Founder[].class);
//            
//            
//        }
//         catch (IOException e) {}
//            e.printStackTrace();
//        }
//        Gson gson = new Gson();
//        
//        
//        
//
//
//        try (Reader reader = new FileReader("result.json")) {
//
//            // Convert JSON File to Java Object
//            Staff [] staffs = new Gson().fromJson(reader, Staff.class);
//			
//			// print staff object
//            System.out.println(staff);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Items items = null;
//
//        Map<String, Object> itemsMap = objectMapper.readValue(new File(
//                "result.json"), new TypeReference<Map<String, Object>>() {
//        });
//        System.out.println(itemsMap.get("id"));
//
//        try {
//            items = objectMapper.readValue(new File("result.json"), Items.class);
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        System.out.println(items);
//

