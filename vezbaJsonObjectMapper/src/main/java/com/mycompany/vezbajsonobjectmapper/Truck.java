
package com.mycompany.vezbajsonobjectmapper;

public class Truck extends Vehicle {
    private double payloadCapacity;
 
    public Truck(String make, String model, double payloadCapacity) {
        super(make, model);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }
 
    // no-arg constructor, getters and setters

    public Truck() {
    }

    @Override
    public String toString() {
        return "Truck{" + "payloadCapacity=" + payloadCapacity + '}';
    }
    
}
