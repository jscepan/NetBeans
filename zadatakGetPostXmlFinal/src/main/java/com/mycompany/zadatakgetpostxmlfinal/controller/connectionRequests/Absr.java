package com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests;

import java.util.ArrayList;
import java.util.List;

public class Absr extends ConnectionToBase {

    public static final String PART_URL = "/p76/types/absr";

    public Absr() {
    }

    public String getAllAbsr() {
        List<String> allAbsrTypes = new ArrayList<>();
        Descendants.getListOfItemsArray().forEach((ct) -> {
            allAbsrTypes.add((ct.getItems().get(0).getId()));
        });
        String x = postMethodForSomeType(PART_URL, allAbsrTypes);

        if (x != null) {
            return x;
        } else {
            return "Error in getting of absr";
        }
    }
}
