package com.isler;

import java.text.NumberFormat;

public class Loan {
    private final double PERCENT = 100.00;
    private final byte MONTHS = 12;
    private double interestRate;
    private int period;




    /* *********************************************
     *   This is not yet complete. I have it printing each value statement. Just need to play with formula.
     * www.mtgprofessor.com/formulas.htm
     *               B = L[c(1+c)^n - (1+c)^p]/[(1+c)^n -1]
     *               B = Balance
     *               L = Loan amount or principal
     *               c = monthly interest
     *               n = number of payment
     *               p = number of payments we have made
     * ***********************************************
     *  */


    public double mortgageCalculation(double principal, double interestRate, int period){
        interestRate = setInterestRate(interestRate);
        period = setPeriod(period);
        double onePlusInterestRate = 1 + interestRate;
        double raisedToThePeriod = Math.pow(onePlusInterestRate,period);
        double monthlyMortgage = principal * ((interestRate * (raisedToThePeriod))/((raisedToThePeriod) - 1));
        printMonthlyMortgage(monthlyMortgage);
        return monthlyMortgage;
    }
    public void printPaymentSchedule(double principal, double interestRate, int period) {
        System.out.println("Payment Schedule: ");
        System.out.println("--------------");

        for(short month = 1; month <= period * MONTHS; month++){
            double balance = balance(principal, setInterestRate(interestRate), setPeriod(period), month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private static void printMonthlyMortgage(double mortgage) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println();
        System.out.println("Monthly Mortgage Payment: " + currency.format(mortgage));
        System.out.println("--------------");
    }

    //Getters and Setters
    private double getInterestRate() {
        return interestRate;
    }

    private double setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        interestRate =  (interestRate/PERCENT);
        return interestRate = interestRate/MONTHS;
    }

    private int getPeriod() {
        return period;
    }

    private int setPeriod(int period) {
        this.period = period;
        return period * MONTHS;
    }

    private double balance(double p, double r, int n, short paymentsMade){
        return p * (Math.pow(1 + r, n) - Math.pow(1 + r, paymentsMade)) / (Math.pow(1 + r, n) - 1);
    }
}























