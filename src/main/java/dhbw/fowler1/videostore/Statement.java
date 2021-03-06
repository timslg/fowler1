package dhbw.fowler1.videostore;

public abstract class Statement {

    public String value(Customer aCustomer) {
        String result = headerString(aCustomer);

        for(Rental aRental : aCustomer.getRentals()) {
            result += eachRentalString(aRental);
        }

        result += footerString(aCustomer);
        return result;
    }

    public abstract String headerString(Customer aCustomer);
    public abstract String eachRentalString(Rental aRental);
    public abstract String footerString(Customer aCustomer);

}
