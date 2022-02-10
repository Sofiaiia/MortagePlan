package org.vaadin.example;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;

import java.awt.*;
import java.util.List;

@Route
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    public MainView(@Autowired FileService service) {

        List<Customer> proscpects = service.getCustomers();
        H1 heading = new H1("Prospects");

        TextField textField = new TextField();;
        textField.setLabel("Name");
        textField.setRequiredIndicatorVisible(true);
        textField.setErrorMessage("This field is required");

        NumberField Total_loan = new NumberField();
        Total_loan.setLabel("Total loan (€)");
        Total_loan.setStep(0.5);
        Total_loan.setValue(0.0);
        Total_loan.setHasControls(true);
        Total_loan.setRequiredIndicatorVisible(true);
        Total_loan.setErrorMessage("This field is required");

        NumberField Yearly_interest = new NumberField();
        Yearly_interest.setLabel("Yearly interest");
        Yearly_interest.setStep(0.3);
        Yearly_interest.setValue(0.0);
        Yearly_interest.setHasControls(true);
        Yearly_interest.setRequiredIndicatorVisible(true);
        Yearly_interest.setErrorMessage("This field is required");

        NumberField years = new NumberField();
        years.setLabel("Years");
        years.setStep(1);
        years.setValue(0.0);
        years.setHasControls(true);
        years.setRequiredIndicatorVisible(true);
        years.setErrorMessage("This field is required");

        FormLayout formLayout = new FormLayout();
        formLayout.add(textField, Total_loan,Yearly_interest,years);

        Grid<Customer> grid = new Grid<>(Customer.class, false);

        grid.addColumn(Customer::getProspectNr).setHeader("Prospect number ").setAutoWidth(true);
        grid.addColumn(Customer::getCustomer).setHeader("Customer").setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Customer::getTotalLoan).setHeader("Total Loan").setAutoWidth(true);
        grid.addColumn(Customer::getYearlyInterestRate).setHeader("Yearly InterestRate").setAutoWidth(true);
        grid.addColumn(Customer::getYears).setHeader("Years").setAutoWidth(true);
        grid.addColumn(Customer::getE).setHeader("Per month").setAutoWidth(true);

        grid.setItems(proscpects);

        Button button = new Button("Add prospect");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(click ->{
            if(!textField.getValue().isEmpty() && !Total_loan.isEmpty() && !Yearly_interest.isEmpty() && !years.isEmpty()){
                Customer tobeadded = service.addCusomer(textField.getValue(), Total_loan.getValue(), Yearly_interest.getValue(), years.getValue(), proscpects.size() + 1);
                tobeadded.calculate();
                proscpects.add(tobeadded);
                grid.getDataProvider().refreshAll();
            }
        });

        setAlignItems(Alignment.CENTER);

        addClassName("centered-content");
        add(heading,formLayout,button,grid);
    }

}
