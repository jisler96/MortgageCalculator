package com.isler;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static final double PERCENT = 100.00;
    static final byte MONTHS = 12;

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        double principal = 0;
        double i = 0;
        int period = 0;


        while(true){
            System.out.print("Principal $1,000.00 - $1,000,000.00: ");
            String principalReader = kb.nextLine();
            principal = Double.parseDouble(principalReader);
            if(principal >= 1_000.00 && principal <= 1_000_000.00) {
                break;
            }
            System.out.println("Enter a number between $1,000.00 and $1,000,000.00");
        }



        while(true){
            System.out.print("Interest Rate: ");
            String interestRateReader = kb.nextLine();
            i = Double.parseDouble(interestRateReader);
            if(i > 0 && i <= 30){
                break;
            }
            System.out.println("Enter a value that is greater than 0 and less than 30.");

        }

        while(true){
            System.out.print("Period: ");
            String periodReader = kb.nextLine();
            period = Integer.parseInt(periodReader);
            if(period > 0 && period <= 30){
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }
        System.out.println("Mortgage: " + mortgageCalculation(principal(principal), interestRate(i), period(period)));
    }

    public static double principal(double principal){
        double p = principal;
        return p;
    }

    public static double interestRate(double interestRate){
         interestRate = (interestRate/PERCENT);
        double r = interestRate/MONTHS;
        return r;
    }

    public static int period(int period){
        int periodInMonths = period * MONTHS;
        return periodInMonths;
    }

    public static String mortgageCalculation(double p, double r, int n){
        double onePlusInterestRate = 1 + r;
        double raisedToThePeriod = Math.pow(onePlusInterestRate,n);
        double mortgage = p * ((r * (raisedToThePeriod))/((raisedToThePeriod) - 1));
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(mortgage);
    }


}
