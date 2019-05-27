package com.mycompany.zadatak2.assignmentModel;

import java.util.List;

public class Properties extends ConnectionToBase {

    public static final String PART_URL = "/p76/types/properties";
    private List<String> ids;

    public Properties(List<String> ids) {
        this.ids = ids;
    }

    public Properties() {
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

}
