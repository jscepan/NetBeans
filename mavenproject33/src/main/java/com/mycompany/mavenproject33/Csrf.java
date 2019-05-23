package com.mycompany.mavenproject33;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

//@JsonTypeName("items")
//@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
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
        return "TokenCSRF{" + "id=" + id + ", attributes=" + attributes + '}';
    }

}
