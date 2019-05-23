package com.mycompany.vezbajsonobjectmapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Car extends Vehicle {
    private int seatingCapacity;
    private double topSpeed;
 @JsonIgnoreProperties({ "model", "seatingCapacity" })
    public Car(String make, String model, int seatingCapacity, double topSpeed) {
        super(make, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
    }

    public Car() {
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    @Override
    public String toString() {
        return "Car{" + "seatingCapacity=" + seatingCapacity + ", topSpeed=" + topSpeed + '}';
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }
 
    // no-arg constructor, getters and setters

    public Car(String make, String model) {
        super(make, model);
    }
}

