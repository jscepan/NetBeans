package com.mycompany.mavenproject33;

import java.util.List;

public class Items {

    private List<Csrf> listOfCsrf;

    public Items() {
    }

    public Items(List<Csrf> listOfCsrf) {
        this.listOfCsrf = listOfCsrf;
    }

    public List<Csrf> getListOfCsrf() {
        return listOfCsrf;
    }

    public void setListOfCsrf(List<Csrf> listOfCsrf) {
        this.listOfCsrf = listOfCsrf;
    }

    @Override
    public String toString() {
        return "Items{" + "listOfCsrf=" + listOfCsrf + '}';
    }
}
