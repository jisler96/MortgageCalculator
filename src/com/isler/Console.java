package com.isler;

import java.util.Scanner;

public class Console {

    Scanner kb = new Scanner(System.in);

    public double readInPrincipal(){
        return readInput("Principal: ", 999, 1_000_000);
    }

    public double readInI() {
        return readInput("Interest Rate: ", 0, 30);
    }

    public int readInPeriod(){
        return (int) readInput("Period: ", 0, 30);
    }

    private double readInput(String prompt, double min, double max){
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
