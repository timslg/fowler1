package dhbw.fowler1.videostore;

public class TextStatement {

    public static String value(Customer aCustomer) {
        String result = "Rental Record for " + aCustomer.getName() + "\n";

        for(Rental aRental : aCustomer.getRentals()) {

            //show figures for this rental
            result += "\t" + aRental.getMovie().getTitle()+ "\t" +
                    String.valueOf(aRental.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
}
