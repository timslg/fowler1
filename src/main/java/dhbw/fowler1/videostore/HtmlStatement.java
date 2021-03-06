package dhbw.fowler1.videostore;

public class HtmlStatement {

    public String value(Customer aCustomer) {
        String result = headerString(aCustomer);

        for(Rental aRental : aCustomer.getRentals()) {
            //show figures for each rental
            result += eachRentalString(aRental);
        }

        //add footer lines
        result += footerString(aCustomer);

        return result;
    }

    public String headerString(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    public String eachRentalString(Rental aRental) {
        return aRental.getMovie().getTitle() + ": " +
                String.valueOf(aRental.getCharge()) + "<BR>\n";
    }

    public String footerString(Customer aCustomer) {
        return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
                "On this rental you earned <EM>" +
                String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
    }

}
