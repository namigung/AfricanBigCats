package com.africanbigcats;
/*
 * Panthera base class that simulates GPS information
 */
public class Jaguar extends Panthera {
    private boolean sleepsInTrees;
    // constructor
    public Jaguar(String name) {
        // call the super-class (parent) to instatiate it
        super(name);
        // initialize attributes
        this.setSpecies("jaguar");
        sleepsInTrees = true;
    }
    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name();
        s += ", ";
        s += "species: " + species();
        s += ", ";
        s += "longitude: " + longitude();
        s += ", ";
        s += "latitude: " + latitude();
        s += ", ";
        s += "weight: " + getWeight();
        s += ", ";
        s += "speed: " + this.speed();
        s += ", ";
        s += "fur: " + fur();
        s += " }";
        return s;
    }
    public String fur() {
        return "spots";
    }
    
    public boolean getSleepInTrees(){
        return sleepsInTrees;
    }
}