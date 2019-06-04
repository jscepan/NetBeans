package com.mycompany.zadatakgetpostxmlfinal.model;

import java.util.List;

public class ViewForType {

    private List<String> ids;

    public ViewForType(List<String> ids) {
        this.ids = ids;
    }

    public ViewForType() {
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "ViewForType{" + "ids=" + ids + '}';
    }

}
