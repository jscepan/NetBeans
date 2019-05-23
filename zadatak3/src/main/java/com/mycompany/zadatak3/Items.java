package com.mycompany.zadatak3;

import java.util.ArrayList;
import java.util.List;


public class Items {

    private String id;
    private Attributes attributes;

    public Items() {
    }

    public Items(String id, Attributes attributes) {
        this.id = id;
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Items{" + "id=" + id + ", attributes=" + attributes + '}';
    }
}
