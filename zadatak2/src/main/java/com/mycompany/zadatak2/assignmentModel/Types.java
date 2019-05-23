package com.mycompany.zadatak2.assignmentModel;

import java.util.ArrayList;

public class Types {

    private String id;
    private String parentId;
    private String name;
    private String displayName;
    private boolean create;
    private boolean modify;
    private boolean read;
    private ArrayList <Types> childItemsList = new ArrayList<>();

    public ArrayList<Types> getChildItemsList() {
        return childItemsList;
    }

    public void setChildItemsList(ArrayList<Types> childItemsList) {
        this.childItemsList = childItemsList;
    }
    
    public Types() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isModify() {
        return modify;
    }

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Types{" + "id=" + id + ", parentId=" + parentId + ", name=" + name + ", displayName=" + displayName + ", create=" + create + ", modify=" + modify + ", read=" + read + ", childItemsList=" + childItemsList + '}';
    }


}