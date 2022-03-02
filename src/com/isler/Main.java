package com.isler;

public class Main {
    public static void main(String[] args){
        var console = new Console();
        double principal = console.readInPrincipal();
        double i = console.readInI();
        int period = console.readInPeriod();
        var loan = new Loan();
        loan.mortgageCalculation(principal, i, period);
        loan.printPaymentSchedule(principal, i, period);
   }
}






