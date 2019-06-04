package com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests;

import com.mycompany.zadatakgetpostxmlfinal.model.types.CatalogTypes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests.ConnectionToBase;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.zadatakgetpostxmlfinal.model.types.Types;

public class Descendants extends ConnectionToBase {

    private static HashMap<String, String> hm = new HashMap<>();
    static final List<CatalogTypes> LIST_OF_ITEMS_ARRAY = new ArrayList<>();
    static final String PART_URL = "/p76/types/WCTYPE|com.lcs.wc.";

    public static List<CatalogTypes> getListOfItemsArray() {
        return LIST_OF_ITEMS_ARRAY;
    }

    public static HashMap<String, String> getHm() {
        return hm;
    }

    public static void setHm(HashMap<String, String> aHm) {
        hm = aHm;
    }

    public Descendants() {
    }

    public void getAllDescendants() {
        //map for all descendants
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

        //creating array of threads
        Thread[] threads = new Thread[hm.size()];
        int i = 0;

        //iterate through whole map to get all descendants and put them in the list (catalogTypes)
        Iterator<Map.Entry<String, String>> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();

            //create new thread and start it
            (threads[i] = new Thread(() -> getDescendant(pair))).start();

            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Descendants.class.getName()).log(Level.SEVERE, null, ex);
            }

            i++;
        }
    }

    public void getDescendant(Map.Entry pair) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            con = createConnection(PART_URL + pair.getValue(), "GET");
            int responseCode = con.getResponseCode();

            //geting answer and parsing of response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String response = readStringFromConnection(con);
                CatalogTypes catalogTypes = mapper.readValue(response, CatalogTypes.class);
                LIST_OF_ITEMS_ARRAY.add(catalogTypes);
            }
        } catch (IOException ex) {
            Logger.getLogger(Descendants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printAllDescedantsTree() {
        //set first element as head of tree
        for (int i = 0; i < LIST_OF_ITEMS_ARRAY.size(); i++) {
            Types headOfTypes = LIST_OF_ITEMS_ARRAY.get(i).getItems().get(0);

            //adding childs on parents list
            for (Types type : LIST_OF_ITEMS_ARRAY.get(i).getItems()) {
                if (type.getParentId() == null) {
                    headOfTypes = type;
                    continue;
                }
                for (Types tGetId : LIST_OF_ITEMS_ARRAY.get(i).getItems()) {
                    if (type.getParentId().equalsIgnoreCase(tGetId.getId())) {
                        tGetId.getChildItemsList().add(type);
                        break;
                    }
                }
            }

            // print of tree
            int increment = 5;
            for (Types t : LIST_OF_ITEMS_ARRAY.get(i).getItems()) {
                if (t.equals(headOfTypes)) {
                    System.out.println("+ " + t.getDisplayName());
                    printList(t.getChildItemsList(), increment);
                }
            }
        }
    }

    //help method for printing of tree (list) from above
    public void printList(List<Types> list, int increment) {
        list.forEach((t) -> {
            printElement(t, increment);
        });
    }

    //help method for printing of element from the list above
    public void printElement(Types types, int increment) {
        String incrementBlanks = "";
        for (int i = 0; i < increment; i++) {
            incrementBlanks += " ";
        }
        if (types.getChildItemsList().isEmpty()) {
            System.out.println(incrementBlanks + "-" + types.getDisplayName());
        } else {
            System.out.println(incrementBlanks + "+" + types.getDisplayName());
            increment += 5;
            printList(types.getChildItemsList(), increment);
        }
    }
}
