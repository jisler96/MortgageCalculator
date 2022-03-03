package com.isler;

import java.util.Scanner;

public class Console {

    private static Scanner kb = new Scanner(System.in);


    public static double readInput(String prompt, double min, double max){
        double value;
        while(true) {
            System.out.print(prompt);
            assert kb != null;
            String string = kb.nextLine();
            value = Double.parseDouble(string);
            if(value > min && value <= max){
                break;
            }
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return value;
    }
}
