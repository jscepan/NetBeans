package com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests;

import java.util.ArrayList;
import java.util.List;

public class AllTypes extends ConnectionToBase {

    public static final String PART_URL = "/p76/types/absr";

    public AllTypes() {
    }

    public String getAllTypes() {
        List<String> allTypes = new ArrayList<>();
        for (int i = 0; i < Descendants.getListOfItemsArray().size(); i++) {
            for (int j = 0; j < Descendants.getListOfItemsArray().get(i).getItems().size(); j++) {
                allTypes.add(Descendants.getListOfItemsArray().get(i).getItems().get(j).getId());
            }
        }
        String x = postMethodForSomeType(PART_URL, allTypes);

        if (x != null) {
            return x;
        } else {
            return "Error in getting of absr";
        }
    }
}
