package com.isler;

public class Main {
    public static void main(String[] args){
        double principal = Console.readInput("Principal: ", 0, 1_000_000);
        double i = Console.readInput("Interest Rate: ", 0, 30);
        int period = (int) Console.readInput("Period: ", 0, 30);

        var calculator = new MortgageCalculator(principal, i, period);
        var mortgageReport = new MortgageReport(calculator);

        System.out.println(calculator.mortgageCalculation());
        mortgageReport.printMonthlyMortgage(calculator.mortgageCalculation());
        mortgageReport.printPaymentSchedule();
   }
}






