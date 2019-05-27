package com.mycompany.zadatak2.assignmentModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Descendants extends ConnectionToBase {

    private static HashMap<String, String> hm = new HashMap<>();
    private static List<CatalogTypes> listOfItemsArray = new ArrayList<>();
    private static final String PART_URL = "/p76/types/WCTYPE|com.lcs.wc.";

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

    public Descendants() {
    }

    public static void getAllDescendants() {
        hm.put("LCSColor", "color.LCSColor/descendants");
        hm.put("LCSDocument", "document.LCSDocument/descendants");
        hm.put("LCSPalette", "color.LCSPalette/descendants");
        hm.put("LCSMaterial", "material.LCSMaterial/descendants");
        hm.put("FlexBOMLink", "flexbom.FlexBOMLink/descendants");
        hm.put("FlexBOMPart", "flexbom.FlexBOMPart/descendants");
        hm.put("LCSProductSeasonLink", "season.LCSProductSeasonLink/descendants");
        hm.put("Placeholder", "placeholder.Placeholder/descendants");
        hm.put("LCSProduct", "product.LCSProduct/descendants");
        hm.put("FlexSpecification", "specification.FlexSpecification/descendants");
        hm.put("LCSSKU", "product.LCSSKU/descendants");
        hm.put("LCSSupplier", "supplier.LCSSupplier/descendants");
        hm.put("LCSSeason", "season.LCSSeason/descendants");
        hm.put("LCSSourcingConfig", "sourcing.LCSSourcingConfig/descendants");
        int responseCode;
        try {
            Iterator<Map.Entry<String, String>> it = hm.entrySet().iterator();
            ObjectMapper mapper = new ObjectMapper();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
                con = ConnectionToBase.createConnection(PART_URL + pair.getValue(), "GET");
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
//        return listOfItemsArray;
    }

    public static void printAllDescedantsTree(List<CatalogTypes> allDescendants) {
//set first element as head of tree
        for (int i = 0; i < allDescendants.size(); i++) {
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
        list.forEach((t) -> {
            printElement(t, increment);
        });
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
            printList(types.getChildItemsList(), increment + increment);
        }
    }
}
