package org.vaadin.example;
import org.junit.Assert;
import org.junit.Test;;
import org.junit.jupiter.api.AfterEach;

import java.util.List;

public class MainViewIT{

    @AfterEach
    public void teardown(){}

    @Test
    public void testAddProspect(){
        FileService service = new FileService();

        String name = "sofia";
        Double loan = 1000.0;
        Double rate = 2.0;
        Double years = 5.0;

        Customer cust = service.addCusomer(name,loan, rate, years,5);

        Assert.assertEquals(cust.getCustomer(),name);
        Assert.assertEquals(cust.getTotalLoan(),loan);
        Assert.assertEquals(cust.getYearlyInterestRate(),rate);
        Assert.assertEquals(cust.getYears(),years);

    }

    @Test
    public void testCalculation(){
        FileService service = new FileService();

        String name = "sofia";
        Double loan = 1000.0;
        Double rate = 5.0;
        Double years = 2.0;

        Customer cust = service.addCusomer(name,loan, rate, years,5);
        cust.calculate();

        Customer addedCustomer = new Customer(name, loan, rate,years,5);
        addedCustomer.setE(43.8713897340686);

        Assert.assertEquals(cust.getE(),addedCustomer.getE(), 0.001);
    }

    @Test
    public void parseFileSize(){
        FileService service = new FileService();
        List<Customer> list = service.getCustomers();

        Assert.assertEquals(list.size(), 4);
    }
}
