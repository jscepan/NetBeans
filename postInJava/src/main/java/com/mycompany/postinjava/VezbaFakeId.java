package com.mycompany.postinjava;
public class VezbaFakeId {
    private int userId;
    private int id;
    private String title;

    public VezbaFakeId(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "{userId=" + userId + ", id=" + id + ", title=" + title + '}';
    }
    
}
