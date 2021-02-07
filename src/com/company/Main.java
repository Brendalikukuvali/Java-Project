package com.company;


import java.util.Scanner;


public class Main {
    private static String amounts;
    private static String names;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the lottery amounts separated by commas: ");

        if (scanner.hasNext()) {
            amounts = scanner.next();
        }

        System.out.print("Please enter the contestants names: ");

        if (scanner.hasNext()) {
            names = scanner.next();
        }

        String[] amountArray = amounts.split(",");
        String[] nameArray = names.split(",");

        award(nameArray, amountArray);
    }

    public static void award(String[] names, String[] amounts) {
        int randomAmount;
        int randomName;

        for (int i = 0; i < amounts.length; i++) {
            randomAmount = (int) (Math.random() * amounts.length);
            int[] usedValue = new int[amounts.length];
            usedValue[i] = randomAmount;
            if (valueUsed(randomAmount, usedValue)) {

                randomName = (int) (Math.random() * names.length);

                System.out.println(names[randomName] + " = "
                        + amounts[randomAmount]);
            } else {
                break;
            }
        }
    }

    private static boolean valueUsed(int myCurrentState, int[] myArray) {
        boolean b = false;

        for (int j : myArray) {
            if (j == myCurrentState) {
                b = true;
                break;
            }
        }
        return b;
    }
}