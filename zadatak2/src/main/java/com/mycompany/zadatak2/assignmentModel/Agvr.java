package com.mycompany.zadatak2.assignmentModel;

import java.util.List;

public class Agvr extends ConnectionToBase {

    public static final String PART_URL = "/p76/types/agvr";
    private List<String> ids;

    public Agvr() {
    }

    public Agvr(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

}
