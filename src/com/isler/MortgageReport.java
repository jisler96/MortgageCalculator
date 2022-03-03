package com.isler;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMonthlyMortgage(double mortgage) {
        System.out.println();
        System.out.println("Monthly Mortgage Payment: " + currency.format(mortgage));
        System.out.println("--------------");
    }

    public void printPaymentSchedule() {
        System.out.println("Payment Schedule: ");
        System.out.println("--------------");
        for (double balance: calculator.getRemainingBalances()) {
            System.out.println(currency.format(balance));
        }
    }
}
