package org.vaadin.example;

public class Customer {

    private String customer;
    private Double totalLoan;
    private Double yearlyInterestRate;
    private Double years;

    private Double E;
    private int prospectNr;

    public Customer(String customer, Double totalLoan, Double yearlyInterestRate, Double years, int prospectNr) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.yearlyInterestRate = yearlyInterestRate;
        this.years = years;
        this.prospectNr = prospectNr;
    }

    public void calculate(){
        Double monthlyRate = (yearlyInterestRate/100) / 12;
        Double payments = years * 12 ;
        Double result = (totalLoan * monthlyRate * powerOf( (1 + monthlyRate),payments)) / (powerOf(1+monthlyRate,payments) - 1);
        setE(result);
    }

    private Double powerOf( double base, double power){
        double result = 1;
        while(power != 0){
            result = result * base;
            power--;
        }
        return result;
    }

    public String getCustomer() {
        return customer;
    }

    public Double getTotalLoan() {
        return totalLoan;
    }

    public Double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public Double getYears() {
        return years;
    }

    public Double getE() {
        return E;
    }

    public int getProspectNr() {
        return prospectNr;
    }

    public void setE(Double e) {
        E = e;
    }
}
