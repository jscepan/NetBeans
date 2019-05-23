package com.mycompany.zadatak2.assignmentModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogTypes {

    private List<Types> items;
    private static Config config;

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

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config config) {
        CatalogTypes.config = config;
    }

    @Override
    public String toString() {
        return "CatalogTypes{" + "items=" + items + '}';
    }



}
