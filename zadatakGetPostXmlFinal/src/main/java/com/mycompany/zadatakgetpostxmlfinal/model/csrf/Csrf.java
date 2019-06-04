package com.mycompany.zadatakgetpostxmlfinal.model.csrf;
public class Csrf {

    private String id;
    private Attributes attributes;

    public Csrf(String id, Attributes attributes) {
        this.id = id;
        this.attributes = attributes;
    }

    public Csrf() {
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
        return "Csrf{" + "id=" + id + ", attributes=" + attributes + '}';
    }


}