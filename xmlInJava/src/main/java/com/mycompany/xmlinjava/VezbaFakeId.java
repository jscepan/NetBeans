package com.mycompany.xmlinjava;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.List;

public class VezbaFakeId {

    private int userId;
    private int id;
    private String title;

    public VezbaFakeId(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public VezbaFakeId() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "{userId=" + userId + ", id=" + id + ", title=" + title + '}';
    }

}