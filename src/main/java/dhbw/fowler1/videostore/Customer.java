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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for(Rental each : _rentals) {
            double thisAmount = each.getCharge();

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints ++;

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }
}
