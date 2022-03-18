public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental (Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie () {
        return _movie;
    }
    /**
     * Metodo que cumple la condicion if y devuelve un double
     * @param each
     * @param thisAmount
     * @return 
     */
    private double getCharge(Rental each, double thisAmount){
        switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
        return thisAmount;
    }
    /**
     * Metodo publico que devuelve el metodo privado getCharge()
     * @param each
     * @param thisAmount
     * @return 
     */
    public double getGetCharge(Rental each, double thisAmount){
        return this.getCharge(each, thisAmount);
    }
}
