// -------------------------------------------------------
// Assignment 4
// Written by: Marko Matijevic (40282591)
// For COMP 248 Section R – Fall 2023
// --------------------------------------------------------

import java.util.Scanner;


public class PoSDemo {
    private static final Scanner kb = new Scanner(System.in);
    public static int PoSContent_selector;

    public static void verify_input() {
        PoSContent_selector = kb.nextInt();
        while (PoSContent_selector < 0 || PoSContent_selector > 4) {
            System.out.println("Sorry but there is no PoS number " + PoSContent_selector);
            System.out.print("--> Try again: (Enter number 0 to 4): ");
            PoSContent_selector = kb.nextInt();
        }
    }

    public static void main(String[] args) {


        // Make 5 sales objects, one for each PoS
        Sales S1 = new Sales(2, 1, 0, 4, 1);
        Sales S2 = new Sales(S1);
        Sales S3 = new Sales(0, 1, 5, 2, 0);
        Sales S4 = new Sales(3, 2, 4, 1, 2);
        Sales S5 = new Sales(S4);

        // Make PrePaiCard objects for each of the arrays for each PoS
        PrePaiCard PP1A = new PrePaiCard("Vegetarian", "40825164", 25, 12);
        PrePaiCard PP1B = new PrePaiCard("Carnivore", "21703195", 3, 12);
        PrePaiCard PP2A = new PrePaiCard("Vegan", "40825164", 7, 12);
        PrePaiCard PP2B = new PrePaiCard("Vegetarian", "21596387", 24, 8);
        PrePaiCard PP3A = new PrePaiCard("Pescatarian", "95432806", 1, 6);
        PrePaiCard PP3B = new PrePaiCard("Halal", "42087913", 18, 12);
        PrePaiCard PP3C = new PrePaiCard("Kosher", "40735421", 5, 4);

        // Assign the PrePaiCard objects to the arrays for each PoS
        PrePaiCard[] C1 = {PP1A, PP1B};
        PrePaiCard[] C2 = {PP2A, PP2B};
        PrePaiCard[] C3 = {PP3A, PP3B, PP3C};
        PrePaiCard[] C4 = {};
        PrePaiCard[] C5 = {};

        // Make an array of new  PoS objects
        PoS[] listPoS = new PoS[5];
        listPoS[0] = new PoS(S1, C1);
        listPoS[1] = new PoS(S2, C2);
        listPoS[2] = new PoS(S3, C3);
        listPoS[3] = new PoS(S4, C4);
        listPoS[4] = new PoS(S5, C5);


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                + "| Welcome to Concordia CostLessBites Catering Sales Counter Application         |\n"
                + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //menu
        String options = "|  What would you like to do?                                          |\n"
                + "|  1. See the content of all PoSs                                               |\n"
                + "|  2. See the content of one PoS                                                |\n"
                + "|  3. List PoSs with same $ amount of sales                                     |\n"
                + "|  4. List PoS with same number of Sales categories                             |\n"
                + "|  5. List PoSs with same $ amount of Sales and same number of Prepaid cards    |\n"
                + "|  6. Add a Prepaid card to an existing PoS                                     |\n"
                + "|  7. Remove an existing Prepaid card from a PoS                                |\n"
                + "|  8. Update the expiry date of an existing Prepaid card                        |\n"
                + "|  9. Add sales to a PoS                                                        |\n"
                + "|  0. To quit                                                                   |\n"
                + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                + "\nPlease enter your choice and press <Enter>: ";

        //
        boolean menu = true;

// while loop which will continue to run the code until option '0' is chosen by the user.
        while (menu) {
            //continuously print the menu options when the code reaches a break; in the case statements.
            System.out.print(options);
            //Input for user to choose which menu option they want to select.
            int selection = kb.nextInt();

            switch (selection) {
// Case 1, prints the Content of each PoS.
                case 1:
                    System.out.println("Content of each PoS:\n" + "---------------------");
                    for (int i = 0; i < listPoS.length; i++) {
                        System.out.println("PoS #" + i + ":");
                        System.out.println(listPoS[i].toString());
                    }
                    break;
// Case 2, prints a specific PoS, between range of 0 to 4.

                case 2:
                    // Prompts user for which input they desire to input
                    System.out.print("Which PoS you want to see the content of? (Enter number 0 to 4):");
                    // verify_input will ensure the value is between the valid range.
                    verify_input();
                    //Print the specific PoS which the users previous input will determine.
                    System.out.println(listPoS[PoSContent_selector].toString());
                    break;

                case 3:
// case 3, List of PoSs with same total $ Sales:
//creates an array for the list totals.
                    int[] list_totals = new int[listPoS.length];
//array loop to create more values for inside  the array
                    for (int i = 0; i < list_totals.length; i++) {
                        list_totals[i] = listPoS[i].totalSales();
                    }

                    System.out.println("List of PoSs with same total $ Sales:\n");
                    for (int i = 0; i < list_totals.length; i++) {
                        for (int j = 0; j < list_totals.length; j++) {
                            // if the values inside the two array examples equal, then prints that they equal
                            // if the list_totals != -100 is used to stop the code from running futher after all
                            // comparisons were made
                            if ((list_totals[i] == list_totals[j]) && (i != j) && (list_totals[i] != -100)) {
                                System.out.print("\t PoS " + i + " and " + j + " both have " + list_totals[i] + "\n");
                            }
                        }
                        list_totals[i] = -100;
                    }
                    break;


                case 4:
                    // case 4 lists same sale categories
                    String[] Breakdown = new String[listPoS.length];
                    for (int i = 0; i < Breakdown.length; i++) {
                        Breakdown[i] = listPoS[i].Breakdown_Sales();
                    }
                    System.out.println("List of PoSs with same Sales categories:\n");
                    for (int i = 0; i < Breakdown.length; i++) {
                        for (int j = 0; j < Breakdown.length; j++) {
// if the breakdown of sales in [i] equals breakdown [j], it will print that they have the same breakdown
                            // this code also follows the same idea as case 3, there is a random value which will stop
                            // the code once it has been processed fully.
                            if ((Breakdown[i].equals(Breakdown[j])) && (i != j && !(Breakdown[i].equals(0)))) {
                                System.out.println("\tPoS " + i + " and " + j + " both have " + Breakdown[i] + "\n");
                            }
                        }
                        Breakdown[i] = String.valueOf(0);

                    }
                    break;


                case 5:
                    // List PoSs with same $ amount of Sales and same number of Prepaid cards
                    String[] case_5_a = new String[listPoS.length];
                    for (int i = 0; i < case_5_a.length; i++) {
                        case_5_a[i] = listPoS[i].Breakdown_Sales();
                    }
                    System.out.println("List of PoSs with same $ amount of sales and same number of PrePaiCards :\n");

                    // uses two loops where i=0 for one, and j=0 for another, in order to create the comparison.
                    for (int i = 0; i < case_5_a.length; i++) {
                        for (int j = 0; j < case_5_a.length; j++) {
// this code also follows the same idea as case 3, there is a random value which will stop
                            // the code once it has been processed fully.
                            if ((case_5_a[i] != (null)) && (case_5_a[j] != null)) {
                                if ((case_5_a[i].equals(case_5_a[j])) && (i != j)) {
                                    System.out.println("\tPoS " + i + " and " + j + "\n");
                                }
                            }
                        }
                        case_5_a[i] = null;

                    }
                    break;

                case 6:
// Add a new prepaid card
                    System.out.print("Which PoS to you want to add an PrePaiCard to? (Enter number 0 to 4):");
                    verify_input();
// Requesting and allowing user to type inputs
                    System.out.println("Please enter the following information so that we may complete the PrePaiCard- ");
                    System.out.println("--> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan):");
                    String cardType = kb.next();
                    System.out.print(" --> ID of the prepaid card:");
                    //card ID is a String in order to ensure values exceeding 2147483647 can be used as an ID.
                    String cardID = kb.next();
                    System.out.print("--> Expiry day number and month (separate by a space):");
                    int expire_day = kb.nextInt();
                    int expire_month = kb.nextInt();
                    // plugs the previous data into the object which will be referenced in PrePaiCard.java
                    PrePaiCard nextCard = new PrePaiCard(cardType, cardID, expire_day, expire_month);
                    System.out.println("You now have " + (listPoS[PoSContent_selector].addCard(nextCard) + " PrePaiCard"));

                    break;

                case 7:
                    // Remove PrePaiCard
                    System.out.print("Which PoS you want to remove an PrePaiCard from? (Enter number 0 to 4):");

                    verify_input();
// Checks if there is a card in the specified location, if not, go back to start of case 7.
                    if (listPoS[PoSContent_selector].PrePaiCard_Count() == 0) {
                        System.out.println("Sorry there is no PrePaiCards in PoS #" + PoSContent_selector);
                        break;
                    }
                    System.out.println("(Enter number 0 to " + (listPoS[PoSContent_selector].PrePaiCard_Count() - 1) + ")");
                    int remove_index = kb.nextInt();
                    boolean remove = listPoS[PoSContent_selector].removeCard(remove_index);
                    if (remove) {
                        System.out.println("PrePaiCard was remove Successfully \n");
                    } else {
                        System.out.println("Failed to remove PrePaiCard, Invalid index.");

                    }


                    break;
                case 8:
                    System.out.print("Which PoS do you want to update an PrePaiCard from? (Enter number 0 to 4):");


                    verify_input();
                    // Checks if there is a card in the specified location, if not, go back to start of case 8.

                    if (listPoS[PoSContent_selector].PrePaiCard_Count() == 0) {
                        System.out.println("Sorry there is no PrePaiCards in PoS #" + PoSContent_selector);
                        break;
                    }

                    System.out.println("Which PrePaiCard do you want to update? (Enter number 0 to " + (listPoS[PoSContent_selector].PrePaiCard_Count() - 1) + ")");
                    int cardindex = kb.nextInt();


                    System.out.print("--> Enter new expiry date day number and month (separate by a space):");
                    int Day_N = kb.nextInt();
                    int Month_N = kb.nextInt();
                    //Update the month and day
                    //Using a method from PoS.java, use previously selected inputs and send them to the method to be evaluated.
                    listPoS[PoSContent_selector].updateDate(cardindex, Day_N, Month_N);


                    break;

                case 9:

                    System.out.print("Which PoS do you want to add Sales to? (Enter number 0 to 4):");
                    verify_input();

                    if (listPoS[PoSContent_selector].PrePaiCard_Count() == 0) {
                        System.out.println("Sorry there is no PrePaiCards in PoS #" + PoSContent_selector);
                        break;
                    }
                    //

                    System.out.println("How many junior, teen ,medium,big and family meal menu do you want to add?");
                    System.out.print("Enter 5 numbers separated by a space): ");
//User desired addition to each category of food.
                    int Ajunior = kb.nextInt();
                    int Ateen = kb.nextInt();
                    int Amedium = kb.nextInt();
                    int Abig = kb.nextInt();
                    int AFamily = kb.nextInt();
                    System.out.print("You now have $" + listPoS[PoSContent_selector].meal_add(Ajunior, Ateen, Amedium, Abig, AFamily) + "\n");
                    //Using a method from Sales.java, use previously selected inputs and send them to the method to be evaluated.


                    break;


                case 0:
                    //exits the code and stops the program
                    System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application");
                    menu = false;


            } //  close the switch


        } // while (selection) close
//close scanner
kb.close();
    }


}
