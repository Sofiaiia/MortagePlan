public class Customer {

    private String customer;
    private Double totalLoan;
    private Double yearlyInterestRate;
    private int years;

    public Customer(String customer, Double totalLoan, Double yearlyInterestRate, int years) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.yearlyInterestRate = yearlyInterestRate;
        this.years = years;
    }

    public void print(int index){

        double E = calculate();

        System.out.println("****************************************************************************************************");
        System.out.println("Prospect " + index +":  " +  this.customer +" wants to borrow " + this.totalLoan + " € for a period of " + this.years + " years and pay "+ E + " € each month");
        System.out.println("****************************************************************************************************");
    }

    private Double calculate(){
        Double monthlyRate = yearlyInterestRate / 12;
        int payments = years * 12 ;

        return (totalLoan * monthlyRate * powerOf( (1 + monthlyRate),payments)) / (powerOf(1+monthlyRate,payments) - 1);
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

    public int getYears() {
        return years;
    }
}
