import java.util.List;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        List<Customer> array = parser.parse();
        int prospectNumber = 1;
        for(Customer mor: array){
            mor.print(prospectNumber);
            prospectNumber++;
        }
    }
}
