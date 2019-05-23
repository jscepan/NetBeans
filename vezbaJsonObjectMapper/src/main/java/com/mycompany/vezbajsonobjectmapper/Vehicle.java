/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vezbajsonobjectmapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Vehicle {
    private String make;
    private String model;


    protected Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
 
    // no-arg constructor, getters and setters

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" + "make=" + make + ", model=" + model + '}';
    }
    
}