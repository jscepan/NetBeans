package com.mycompany.zadatak2.assignmentModel;

import java.util.List;

public class CatalogTypes {

    private List<Types> items;
    public static final String PART_URL = "/p76/types";
    
    public CatalogTypes() {
    }

    public CatalogTypes(List<Types> items) {
        this.items = items;
    }

    public List<Types> getItems() {
        return items;
    }

    public void setItems(List<Types> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CatalogTypes{" + "items=" + items + '}';
    }
}
