package com.isler;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static final double PERCENT = 100.00;
    static final byte MONTHS = 12;

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        System.out.print("Principal: ");
        String principalReader = kb.nextLine();
        double principal = Double.parseDouble(principalReader);

        System.out.print("Interest Rate: ");
        String interestRateReader = kb.nextLine();
        double i = Double.parseDouble(interestRateReader);

        System.out.print("Period: ");
        String periodReader = kb.nextLine();
        int period = Integer.parseInt(periodReader);

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
