package dhbw.fowler1.videostore;

public class HtmlStatement {

    public static String value(Customer aCustomer) {
        String result = "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";

        for(Rental aRental : aCustomer.getRentals()) {

            //show figures for each rental
            result += aRental.getMovie().getTitle() + ": " +
                    String.valueOf(aRental.getCharge()) + "<BR>\n";

        }

        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) +
                "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";

        return result;
    }
}
