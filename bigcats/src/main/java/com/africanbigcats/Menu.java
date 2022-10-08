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
                break;
            case 'f':
                break;
            case 'l':
                executeList(catList);
                break;
            case 'q':
                executeQuit();
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
        float catNum = 0;
        Panthera result;
        System.out.print("Enter 1 for Tiger, 2 for Lion, 3 for Jaguar: ");
        String val = input.nextLine();
        catNum = Float.valueOf(val);
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
            System.out.print("Error: invalid big cat type. Creating a tiger named" + name);
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
        boolean pass = true;
        for (int i = 0; i < catList.size(); i++){
            String bigcat = catList.get(i).name();
            if (bigcat.equals(name)){
                System.out.print("Error: this big cat already exists");
                pass = false;
            }
        }
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
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }
        System.out.println();
    }
    /*
        TIP:
        Additional methods and functionality need to be added to this class.
    */
}