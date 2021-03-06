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
        String result = "Rental Record for " + getName() + "\n";

        for(Rental aRental : _rentals) {

            //show figures for this rental
            result += "\t" + aRental.getMovie().getTitle()+ "\t" +
                    String.valueOf(aRental.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    public String htmlStatement() {

        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

        for(Rental aRental : _rentals) {

            //show figures for each rental
            result += aRental.getMovie().getTitle() + ": " +
                    String.valueOf(aRental.getCharge()) + "<BR>\n";

        }

        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) +
                "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";

        return result;

    }

    private double getTotalCharge() {
        double result = 0;
        for(Rental aRental : _rentals) {
            result += aRental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
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
}
