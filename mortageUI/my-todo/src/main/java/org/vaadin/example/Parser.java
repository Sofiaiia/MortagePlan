package org.vaadin.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public Parser() { }

    public List<Customer> parse(){
        List<Customer> array = new ArrayList<Customer>();
        try(InputStream inputStream = this.getClass().getResourceAsStream("/prospects.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            String line = "";
            int index = 1;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    break;
                }
                if (index != 1) {
                    String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    Customer newObj = new Customer(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]),index-1);
                    newObj.calculate();
                    array.add(newObj);
                }
                index++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return array;
    }
}
