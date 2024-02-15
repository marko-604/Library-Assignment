import java.util.Scanner;
// -------------------------------------------------------
// Assignment 4
// Written by: Marko Matijevic (40282591)
// For COMP 248 Section R – Fall 2023
// --------------------------------------------------------
public class Sales {

// basic attributes, do not change, so final
    final public static int JUNIOR_PRICE = 5;
    final public static int TEEN_PRICE = 10;
    final public static int MEDIUM_PRICE = 12;
    final public static int BIG_PRICE = 15;
    final public static int FAMILY_PRICE = 20;

    // amount sold of each type of meal, variable, needs to be able to be changed later
    private int amount_sold_junior = 0;
    private int amount_sold_teen = 0;
    private int amount_sold_medium = 0;
    private int amount_sold_big = 0;
    private int amount_sold_family = 0;


    Sales() {

    }
// takes all the values presented and creates this.___ in order to prevent leaks.
    public Sales(int amount_sold_junior, int amount_sold_teen, int amount_sold_medium, int amount_sold_big, int amount_sold_family) {
        this.amount_sold_junior = amount_sold_junior;
        this.amount_sold_teen = amount_sold_teen;
        this.amount_sold_medium = amount_sold_medium;
        this.amount_sold_big = amount_sold_big;
        this.amount_sold_family = amount_sold_family;
    }

    // copy method to get amount sold of each type
    public Sales(Sales sales) {

        this.amount_sold_junior = sales.getAmount_sold_junior();
        this.amount_sold_teen = sales.getAmount_sold_teen();
        this.amount_sold_medium = sales.getAmount_sold_medium();
        this.amount_sold_big = sales.getAmount_sold_big();
        this.amount_sold_family = sales.getAmount_sold_family();
    }

// adds the amount which fits the method requirements to the existing this.amount_sold_----
    public void addSales(int amount_sold_junior, int amount_sold_teen, int amount_sold_medium, int amount_sold_big, int amount_sold_family) {
        this.amount_sold_junior += amount_sold_junior;
        this.amount_sold_teen += amount_sold_teen;
        this.amount_sold_medium += amount_sold_medium;
        this.amount_sold_big += amount_sold_big;
        this.amount_sold_family += amount_sold_family;
    }
// Prints the total sales, using final price * whichever value is amounted to the previous comments total amount sold.
    public float salesTotal() {

        return JUNIOR_PRICE * this.amount_sold_junior + TEEN_PRICE * this.amount_sold_teen + MEDIUM_PRICE * this.amount_sold_medium + BIG_PRICE * this.amount_sold_big + FAMILY_PRICE * this.amount_sold_family;

    }
//  !!!!   gets the amount sold of each type of meal and returns the amount sold from which will be later used to show how much was sold after potential changes
    public int getAmount_sold_junior() {
        return this.amount_sold_junior;
    }

    public void setAmount_sold_junior(int newAmount_sold_junior) {

        this.amount_sold_junior = newAmount_sold_junior;
    }

    public int getAmount_sold_teen() {
        return this.amount_sold_teen;
    }

    public void setAmount_sold_teen(int newAmount_sold_teen) {
        this.amount_sold_teen = newAmount_sold_teen;

    }

    public int getAmount_sold_medium() {
        return this.amount_sold_medium;
    }

    public void setAmount_sold_medium(int newAmount_sold_medium) {
        this.amount_sold_teen = newAmount_sold_medium;

    }

    public int getAmount_sold_big() {
        return this.amount_sold_big;
    }

    public void setAmount_sold_big(int newAmount_sold_big) {
        this.amount_sold_teen = newAmount_sold_big;

    }

    public int getAmount_sold_family() {
        return this.amount_sold_family;
    }

    public void setAmount_sold_family(int newAmount_sold_family) {
        this.amount_sold_teen = newAmount_sold_family;

    }

// returns string of new amount sold the character 'x' followed by the corresponding final price.
    public String toString() {

        return this.amount_sold_junior + " x " + JUNIOR_PRICE + " + " + amount_sold_teen + " x " + TEEN_PRICE + " + " + amount_sold_medium + " x " + MEDIUM_PRICE + " + " + amount_sold_big + " x " + BIG_PRICE + " + " + amount_sold_family + " x " + FAMILY_PRICE;
    }
// Returns true or false after converting objects to the correct class type, depending on if all are equal.

    public boolean equals(Sales sale) {
        return sale.getAmount_sold_junior() == this.amount_sold_junior && sale.getAmount_sold_teen() == this.amount_sold_teen && sale.getAmount_sold_medium() == this.amount_sold_medium && sale.getAmount_sold_big() == this.amount_sold_big && sale.getAmount_sold_family() == this.amount_sold_family;

    }


}



