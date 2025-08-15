package com.bank;



//bean,pojo,emptyclass
public class LoanBean {

/**
 * LoanBean is a simple JavaBean to store loan application details.
 */


    // Customer name
    private String customerName;

    // Loan amount in currency 
    private double loanAmount;

    // Loan tenure (number of months or years)
    private int tenure;

    // EMI amount (calculated based on loan details)
    private double emi;

    // ---- Default Constructor ----
    public LoanBean() {
    }

    // ---- Parameterized Constructor ----
    public LoanBean(String customerName, double loanAmount, int tenure, double emi) {
        this.customerName = customerName;
        this.loanAmount = loanAmount;
        this.tenure = tenure;
       
    }

    // ---- Getters and Setters ----

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    // ---- Optional: Method to calculate EMI ----
    public void calculateEmi(double annualInterestRate) {
        // Convert annual interest rate (%) to monthly rate
        double monthlyRate = annualInterestRate / 12 / 100;

        // EMI formula: [P * r * (1 + r)^n] / [(1 + r)^n – 1]
        this.emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, tenure)) /
                   (Math.pow(1 + monthlyRate, tenure) - 1);
    }
}
