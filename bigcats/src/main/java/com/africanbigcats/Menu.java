package com.africanbigcats;

import java.util.*;
/*
 * Menu class for the african big cat app
 */
public class Menu {
    // attributes
    private Scanner input;
    // constructor
    public Menu() {
        // initialize attributes
        this.input = new Scanner(System.in);
    }
    // prints the menu
    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();
        /*
            TIP:
            In this area of the code, the additional commands need to be created 
and added to the menu.
        */
        printCommand('c',"[C]reates a big cat");
        printCommand('d', "[D]eletes a big cat");
        printCommand('f', "[F]inds a Big Cat");
        printCommand('l',"[L]ists all big Cats");
        printCommand('r', "[R}isk Report");
        printCommand('w', "[W]arning Report");
        printCommand('q',"[Q]uits");
        printLine();
    }
    private static void printLine() {
        
System.out.println("----------------------------------------------------------" );
    }
    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }
    // get first character from input
    public Character getCommand() {
        Character command = '_';
        String rawInput = input.nextLine();
        
        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }
        return command;
    }
    // command switch
    public Boolean executeCommand(Character command, LinkedList<Panthera> catList) 
{
        Boolean success = true;
        /*
            TIP:
            In this area of the code, the additional commands need to be created 
and added.
        */
        switch(command) {
            case 'c':
                executeCreate(catList);
                break;
            case 'd':
                deleteBigCat(catList);
                break;
            case 'f':
                findBigCat(catList);
                break;
            case 'l':
                executeList(catList);
                break;
            case 'q':
                executeQuit();
                break;
            case 'r':
                riskReport(catList);
                break;
            case 'w':
                warningReport(catList);
                break;
            default:
                System.out.println("ERROR: Unknown commmand");
                success = false;
          }
        return success;
    }
    // update the position of all the cats
    public void update(LinkedList<Panthera> catList) {
        // update by moving all the cats
        for (Panthera cat: catList) {
            cat.move();
        }
    }
    // quit the app
    public void executeQuit() {
        // close the scannner
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();
    }
    public Panthera getNewCat(String name) {
        /*
            TIP:
            In this area of the code, students need to get input from the user for 
            the type of cat 
            and create the correct type.
            Currently, the code always create a Tiger.  But, support for Lions and Jaguars
            also needs to be added.
        */
        Panthera result;
        try{
            int catNum = 0;
            System.out.print("Enter 1 for Tiger, 2 for Lion, 3 for Jaguar: ");
            String val = input.nextLine();
            catNum = Integer.valueOf(val);
            if (catNum == 1){
                result = new Tiger(name);
            }
            else if (catNum == 2){
                result = new Lion(name);
            }
            else if (catNum == 3){
                result = new Jaguar(name); 
            }
            else{
                System.out.print("Error: invalid big cat type. Creating a tiger named " + name);
                result = new Tiger(name);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Error: invalid big cat type. Creating a tiger named " + name);
            result = new Tiger(name);
        }
        return result;
    }
    // create a cat, if it's unique
    public void executeCreate(LinkedList<Panthera> catList) {
        // get the name
        System.out.println();
        System.out.print("Enter a name for the big cat to create: ");
        String name = input.nextLine();
        System.out.println();
          /*
            TIP:
            In this area of the code, students would need to add in checking if the
            cat name
            already exists in order to prevent duplicates
        */
        //checks for duplicates
        boolean pass = true;
        for (int i = 0; i < catList.size(); i++){
            String bigcat = catList.get(i).name();
            if (bigcat.equals(name)){
                System.out.println("Error: this big cat already exists");
                pass = false;
            }
        }
        //if no duplicates found, prints that it has been added to list
        if (pass == true){
            Panthera cat = getNewCat(name);
            catList.add(cat);
            System.out.println("Status: " + name + " has been added");
        }
    }
    // list all big cats 
    public void executeList(LinkedList<Panthera> catList) {
        System.out.println();
        printLine();
        System.out.println("African Big Cat List");
        printLine();
        Panthera cat;
        if (catList.size() > 0) {
            for (Integer i = 0; i < catList.size(); i++) {
                cat = catList.get(i);
                //prints a numbered list
                System.out.println("#" + (i+1) + cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }
        System.out.println();
    }
    
    //removes big cat from list
    public void deleteBigCat(LinkedList<Panthera> catList){
        System.out.print("What cat do you want to remove (enter name)?");
        String name = input.nextLine();
        //iterates to find the name of the cat and removes it
        for (int i = 0; i < catList.size(); i++){
            String bigcat = catList.get(i).name();
            if (bigcat.equals(name)){
                catList.remove(i);
            }
        }
        System.out.println();
        System.out.println(name + " has been removed");
    }

    //finds big cat
    public void findBigCat(LinkedList<Panthera> catList){
        System.out.print("Enter the name of the cat or what you think the name of cat is: ");
        boolean bigCatFound = false;
        String name = input.nextLine();
        //iterates to see if the entered name is in the list
        for (int i = 0; i < catList.size(); i++){
            String bigcat = catList.get(i).name();
            if (bigcat.indexOf(name) != -1){
                System.out.println(catList.get(i));
                bigCatFound = true;
            }
        }
        System.out.println();
        //if there was no cat found print message
        if (bigCatFound == false){
            System.out.print("We could not find this Big Cat");
        }
    }

    public void riskReport(LinkedList<Panthera> catList){
        System.out.print("Enter the name of the first cat: ");
        String cat1 = input.nextLine();
        System.out.print("Enter name of second cat: ");
        String cat2 = input.nextLine();
        //stores cats longitude and latitude
        float cat1long =0;
        float cat1lat = 0;
        float cat2long = 0;
        float cat2lat =0;
        //used to print error message if the cats don't exist in the list
        boolean foundcat1 = false;
        boolean foundcat2 = false;

        for (int i = 0; i < catList.size(); i++){
            if (catList.get(i).name().equals(cat1)){
                cat1long = catList.get(i).longitude();
                cat1lat = catList.get(i).latitude();
                foundcat1 = true;
            }
            if(catList.get(i).name().equals(cat2)){
                cat2long = catList.get(i).longitude();
                cat2lat = catList.get(i).latitude();
                foundcat2 = true;
            }
        }

        if (foundcat2 && foundcat1){
        //calculates distance between big cats
        double distanceBetween = calcDistance(cat1long, cat1lat, cat2long, cat2lat);
        System.out.println("The distance between " + cat1 + " and " + cat2 + " is " + distanceBetween );
        }
        else{
            System.out.println("cat cannot be found");
        }
    }
    
    public void warningReport(LinkedList<Panthera> catList){
        //prompts user for their longitude/latitude
        System.out.print("What is your longitude: ");
        String num1 = input.nextLine();
        Float yourLong = Float.valueOf(num1);
        System.out.print("What is your latitude: ");
        String num2 = input.nextLine();
        Float yourLat = Float.valueOf(num2);

        //sets the minimum distance
        float catLong = catList.get(0).longitude();
        float catLat = catList.get(0).latitude();
        double distanceBetween = calcDistance(catLong, catLat, yourLong, yourLat);
        double minDistance = distanceBetween;
        String closestCat = catList.get(0).name();

        for (int i = 0 ; i < catList.size(); i++){
            catLong = catList.get(i).longitude();
            catLat = catList.get(i).latitude();
            distanceBetween = calcDistance(catLong, catLat, yourLong, yourLat);
            if (distanceBetween < minDistance){
                minDistance = distanceBetween;
                closestCat = catList.get(i).name();
            }
        }
    
        System.out.println("The closest cat is " + closestCat + " which is at distance of " + minDistance);
    }

    public double calcDistance( float longC, float latC, float longP, float latP){
        float longDiff = longP - longC;
        float latDiff = latP - latC;
        double insideSqrtRt = longDiff * longDiff + latDiff * latDiff;
        double distanceBetween = Math.sqrt(insideSqrtRt); 
        return distanceBetween;
    }
}


