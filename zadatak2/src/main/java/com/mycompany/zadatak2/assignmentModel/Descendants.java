package com.mycompany.zadatak2.assignmentModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Descendants {

    private static HashMap<String, String> hm = new HashMap<>();
    private static Config config;
    private static List<CatalogTypes> listOfItemsArray = new ArrayList<>();

    public static List<CatalogTypes> getListOfItemsArray() {
        return listOfItemsArray;
    }

    public static void setListOfItemsArray(List<CatalogTypes> listOfItemsArray) {
        Descendants.listOfItemsArray = listOfItemsArray;
    }

    public static HashMap<String, String> getHm() {
        return hm;
    }

    public static void setHm(HashMap<String, String> aHm) {
        hm = aHm;
    }

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config aConfig) {
        config = aConfig;
    }

    public Descendants() {
    }

    public static List getAllDescendants() {
//        List<CatalogTypes> listOfItemsArray = new ArrayList<>();
        hm.put("LCSColor", "color.LCSColor");
        hm.put("LCSDocument", "document.LCSDocument");
        hm.put("LCSPalette", "color.LCSPalette");
        hm.put("LCSMaterial", "material.LCSMaterial");
        hm.put("FlexBOMLink", "flexbom.FlexBOMLink");
        hm.put("FlexBOMPart", "flexbom.FlexBOMPart");
        hm.put("LCSProductSeasonLink", "season.LCSProductSeasonLink");
        hm.put("Placeholder", "placeholder.Placeholder");
        hm.put("LCSProduct", "product.LCSProduct");
        hm.put("FlexSpecification", "specification.FlexSpecification");
        hm.put("LCSSKU", "product.LCSSKU");
        hm.put("LCSSupplier", "supplier.LCSSupplier");
        hm.put("LCSSeason", "season.LCSSeason");
        hm.put("LCSSourcingConfig", "sourcing.LCSSourcingConfig");
        config = Config.loadConfigurations();
        int responseCode;
        try {
            Iterator<Map.Entry<String, String>> it = hm.entrySet().iterator();
            ObjectMapper mapper = new ObjectMapper();;
            while (it.hasNext()) {
                Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
                HttpURLConnection con = ConnectionToBase.createConnection(config.getUrl() + "/p76/types/WCTYPE|com.lcs.wc." + pair.getValue() + "/descendants", "GET");
                responseCode = con.getResponseCode();

//geting answer and parsing of response
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    String response = ConnectionToBase.readStringFromConnection(con);
                    CatalogTypes catalogTypes = mapper.readValue(response, CatalogTypes.class);
                    listOfItemsArray.add(catalogTypes);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Descendants.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOfItemsArray;
    }

    public static void printAllDescedantsTree(List<CatalogTypes> allDescendants) {
//set first element as head of tree
        for (int i = 0; i < 10; i++) {
            Types headOfTypes = allDescendants.get(i).getItems().get(0);

//adding childs on parents list
            for (Types type : allDescendants.get(i).getItems()) {
                if (type.getParentId() == null) {
                    headOfTypes = type;
                    continue;
                }
                for (Types tGetId : allDescendants.get(i).getItems()) {
                    if (type.getParentId().equalsIgnoreCase(tGetId.getId())) {
                        tGetId.getChildItemsList().add(type);
                        break;
                    }
                }
            }

// print of tree
            int increment = 5;
            for (Types t : allDescendants.get(i).getItems()) {
                if (t.equals(headOfTypes)) {
                    System.out.println("+ " + t.getDisplayName());
                    printList(t.getChildItemsList(), increment);
                }
            }
        }
    }

    public static void printList(List<Types> list, int increment) {
        for (Types t : list) {
            printElement(t, increment);
        }
    }

    public static void printElement(Types types, int increment) {
        String incrementBlanks = "";
        for (int i = 0; i < increment; i++) {
            incrementBlanks += " ";
        }
        if (types.getChildItemsList().isEmpty()) {
            System.out.println(incrementBlanks + "-" + types.getDisplayName());
        } else {
            System.out.println(incrementBlanks + "+" + types.getDisplayName());
            printList(types.getChildItemsList(), increment += increment);
        }
    }
}
