package dhbw.fowler1.videostore;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _priceCode.getPriceCode();
    }

    public void setPriceCode(int arg) {

        switch (arg) {
            case REGULAR:
                _priceCode = new RegularPrice();
                break;
            case CHILDRENS:
                _priceCode = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                _priceCode = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }

        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    public int frequentRenterPoints(int daysRented) {
        int result = 1;

        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            result++;

        return result;
    }


}
