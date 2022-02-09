package org.vaadin.example;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FileService implements Serializable {

    public List<Customer> getCustomers() {
        Parser parser = new Parser();
        return parser.parse();
    }

    public Customer addCusomer(String customer, Double totalLoan, Double yearlyInterestRate, Double years, int prospectNr){
        return new Customer(customer,totalLoan,yearlyInterestRate,years,prospectNr);
    }
}
