package dhbw.fowler1.videostore;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private ArrayList<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {

        return TextStatement.value(this);

    }

    public String htmlStatement() {

        return HtmlStatement.value(this);

    }

    public double getTotalCharge() {
        double result = 0;
        for(Rental aRental : _rentals) {
            result += aRental.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        for(Rental aRental : _rentals) {
            result += aRental.getFrequentRenterPoints();
        }
        return result;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public ArrayList<Rental> getRentals() {
        return _rentals;
    }
}
