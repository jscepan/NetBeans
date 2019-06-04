package com.mycompany.zadatakgetpostxmlfinal.model.csrf;

import java.util.List;

public class CatalogCsrf {

    private List<Csrf> items;

    public CatalogCsrf() {
    }

    public CatalogCsrf(List<Csrf> items) {
        this.items = items;
    }

    public List<Csrf> getItems() {
        return items;
    }

    public void setItems(List<Csrf> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CatalogCsrf{" + "items=" + items + '}';
    }


}
