package com.isler;

public class MortgageCalculator {
    private final double PERCENT = 100.00;
    private final byte MONTHS = 12;
    private double principal;
    private double interestRate;
    private int period;

    public MortgageCalculator(double principal, double interestRate, int period) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.period = period;
    }
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


    public double mortgageCalculation(){
        double onePlusInterestRate = 1 + interestRate;
        double raisedToThePeriod = Math.pow(onePlusInterestRate,period);
        return principal * ((interestRate * (raisedToThePeriod))/((raisedToThePeriod) - 1));
    }

    public double balance(short paymentsMade){
        double monthlyInterest = getMonthlyInterest();
        double numberOfPayments = getNumberOfPayments();
        return principal * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, paymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = balance(month);
        }
        return balances;
    }

    //Getters and Setters
    public double getInterestRate() {
        return interestRate;
    }

    private int getNumberOfPayments() {
        return period * MONTHS;
    }

    private double getMonthlyInterest() {
        return interestRate / PERCENT / MONTHS;
    }
}























