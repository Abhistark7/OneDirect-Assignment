package Question1;

public class TaxCalculator {

    //function to calculate tax
    public double calculate_tax(String type, int price) {

        double tax = 0.0;
        double surcharge = 0.0;
        double final_price = 0.0;

        switch (type) {

            case "raw":
                tax = price * 0.125;
                break;

            case "manufactured":
                tax = price * 0.125 + 0.02 * (price + price * 0.125);
                break;

            case "imported":
                tax = price * 0.1;
                final_price = price + tax;
                if (final_price <= 100) {
                    surcharge = 5;
                } else if (final_price > 100 && final_price <= 200) {
                    surcharge = 10;
                } else if (final_price > 200) {
                    surcharge = final_price * 1.1;
                }
                tax = tax + surcharge;

        }
        return tax;
    }
}