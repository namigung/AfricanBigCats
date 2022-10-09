package com.africanbigcats;
/*
 * Panthera base class that simulates GPS information
 */

public class Panthera extends PantheraGPS {
    /*
        TIP:
        Students will need to add additional attributes and methods to complete 
        this classes
        implementation.
     */

    private int weight; 
    private float speed;

    // constructor
    public Panthera(String name) {
        // call the super-class (parent) to instatiate it
        super(name);
        // initialize attributes
        this.setSpecies("panthera");
        //randomizes a weight between 10 and 600 pounds
        weight = (int)(Math.random()*(591) + 10 );
    }

    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + this.name();
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += ", ";
        s += "weight: " + this.getWeight();
        s += ", ";
        s += "speed: " + this.speed();
        s += " }";
        return s;
    }

    //roar method
    public String roar(){
        return "Rrrrrrrrroooooooaaaaarrrrr!";
    }

    //weight getter method
    public int getWeight() {
        return weight;
    }

    //randomly generates a speed from between 0 and 50
    public float speed(){
        speed = (int)(Math.random()*(51));
        return speed;

    }
}
