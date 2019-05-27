package com.mycompany.zadatak2.assignmentModel;

import java.util.List;

public class Absr extends ConnectionToBase {

    public static final String PART_URL = "/p76/types/absr";
    private List<String> ids;

    public Absr() {
    }

    public Absr(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}

