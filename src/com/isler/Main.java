package com.isler;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static final double PERCENT = 100.00;
    static final byte MONTHS = 12;

    public static void main(String[] args){

        double principal = readInput("Principal: ", 999, 1_000_000);
        double i = readInput("Interest Rate: ", 0, 30);
        int period = (int) readInput("Period: ", 0, 30);
        double mortgage = mortgageCalculation(principal(principal), interestRate(i), period(period));
        printMortgage(mortgage);
        printPaymentSchedule(principal, i, period);
    }

    private static void printMortgage(double mortgage) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("--------------");
        System.out.println("Monthly Mortgage Payment: " + currency.format(mortgage));
    }

    private static void printPaymentSchedule(double principal, double i, int period) {
        System.out.println();
        System.out.println("Payment Schedule: ");
        System.out.println("--------------");
        for(short month = 1; month <= period * MONTHS; month++){
            double balance = balance(principal(principal), interestRate(i), period(period), month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double principal(double principal){
        return principal;
    }

    public static double interestRate(double interestRate){
         interestRate = (interestRate/PERCENT);
        return interestRate/MONTHS;
    }

    public static int period(int period){
        return period * MONTHS;
    }

    public static double mortgageCalculation(double p, double r, int n){
        double onePlusInterestRate = 1 + r;
        double raisedToThePeriod = Math.pow(onePlusInterestRate,n);
        return p * ((r * (raisedToThePeriod))/((raisedToThePeriod) - 1));
    }

    /* *********************************************
    *   This is not yet complete. I have it printing each value statement. Just need to play with formula.
    * www.mtgprofessor.com/formulas.htm
    *               B = L[c(1+c)^n - (1+c)^p]/[(1+c)^n -1]
    *               B = Balance
    *               L = Loan amount or principal
    *               c = monthly interest
    *               n = number of payments
    *               p = number of payments we have made */
    public static double balance(double p, double r, int n, short paymentsMade){
        return p * (Math.pow(1 + r, n) - Math.pow(1 + r, paymentsMade)) / (Math.pow(1 + r, n) - 1);
    }

    public static double readInput(String prompt, double min, double max){
        Scanner kb = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
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
