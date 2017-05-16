package com.manchesterdigital.coffeeshop.shop;

import java.util.Scanner;

/*
    TODO:
    Add junit4
    Add maven and gradle
    Write a cheat sheet for the assessors on what kind of things we are expecting the groups to do/achieve
 */
public class CoffeeShop {

    public void serveCustomer() {

        System.out.println("Welcome to the coffee shop. Let me take your order");
        boolean withMilk = askIfWithMilk();
        int numberOfSugars = askHowManySugars();

        System.out.println();
        System.out.println("Thanks, I'll make that for you now");
        makeCoffee(withMilk, numberOfSugars);

        System.out.println();
        takePayment(2.20, numberOfSugars);

        System.out.println();
        System.out.println("Here you go.");
        describeCoffee(withMilk, numberOfSugars);
    }

    private boolean askIfWithMilk() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want milk?");

        Boolean result = null;
        while(result == null) {
            String input = scanner.next();

            if ("yes".equalsIgnoreCase(input) || "y".equalsIgnoreCase(input)) {
                result = true;
            } else if ("no".equalsIgnoreCase(input) || "n".equalsIgnoreCase(input)) {
                result = false;
            } else {
                System.out.println("Please enter 'yes' or 'no'");
            }
        }

        return result;
    }

    private int askHowManySugars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many sugars do you want?");

        Integer result = null;
        while(result == null) {
            String input = scanner.next();

            try {
                result = Integer.parseInt(input);
            } catch(NumberFormatException ex) {
                System.out.println("Please enter a number");
            }
        }

        return result;
    }

    private void makeCoffee(boolean withMilk, int numberOfSugars) {
        System.out.println("  click click");
        System.out.println("  chug chug chug");
        System.out.println("  grrrrrrrk");
        System.out.println("  gurgle");
        System.out.println("  blop blop");
    }

    private void takePayment(double priceOfCoffee, int numberOfSugars) {
        double sugarTax = numberOfSugars * 0.1;
        double totalPrice = priceOfCoffee + sugarTax;

        String formattedPrice = String.format("£%.2f", totalPrice);
        System.out.println("That will be " + formattedPrice + " please");
        System.out.println("Please beep your card");

        boolean beeped = false;
        while (!beeped) {
            Scanner scanner = new Scanner(System.in);
            String theBeep = scanner.next();
            beeped = theBeep.equalsIgnoreCase("beep");

            if (!beeped) {
                System.out.println("Sorry that didn't read properly could you beep it again please");
            } else {
                System.out.println("Thanks.");
                System.out.println("  chrrrt chrrrt");
                System.out.println("  rrrip");
                System.out.println("Here is your receipt for " + formattedPrice + ".");
            }
        }
    }

    private void describeCoffee(boolean withMilk, int numberOfSugars) {
        StringBuilder descriptionBuilder = new StringBuilder("A delicious coffee ")
                .append(withMilk ? "with milk" : "without milk");

        if (numberOfSugars > 0) {
            descriptionBuilder.append(" and " + numberOfSugars + " sugars.");
        } else {
            descriptionBuilder.append(" and no sugar.");
        }

        System.out.println(descriptionBuilder.toString());
    }
}
