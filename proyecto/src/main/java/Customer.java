import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer (String name) {
        _name = name;
    }

    public void addRental (Rental arg) {
        _rentals.addElement(arg);
    }

    public String statement () {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // determine amounts for each line
            each.getGetCharge(each,thisAmount); //LLamo al metodo publico que he creado en la clase Rental
            
            getFrequentRenterPoints(frequentRenterPoints,each,thisAmount,totalAmount,result); //Llamo al metodo que he creado getFrequentRenterPoints()
            
            
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    public String getName() {
        return _name;
    }
    /**
     * Metodo que cumple la condicion if y devuelve 2 o 1
     * @param frequentRenterPoints
     * @param each
     * @param thisAmount
     * @param totalAmount
     * @param result
     * @return 
     */
    public int getFrequentRenterPoints(int frequentRenterPoints,Rental each, double thisAmount, double totalAmount, String result){
        frequentRenterPoints ++;
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1){
                frequentRenterPoints ++;
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
            return 2;
        }else{
            return 1;
        }
    }
}
