/**
 *
 * @author Abhishek sahu
 */


package Question4;

public class Item {

    String name;
    String type;
    int price;
    int quantity;
    double tax;
    double finalPrice;

    public Item(){
        this.name = "";
        this.type = "";
        this.price = 0;
        this.quantity = 0;
        this.tax = 0;
        this.finalPrice = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }

    public double getTax(){
        return tax;
    }

    public double getFinalPrice(){
        return finalPrice;
    }


    //method to calculate tax and final price
    public void calculateTax()
    {
        if(this.type.equalsIgnoreCase("raw"))
        {
            this.tax = 0.125 * this.price ;
        }
        else if(this.type.equalsIgnoreCase("manufactured"))
        {
            this.tax = 0.1475 * this.price ;
        }
        else if(this.type.equalsIgnoreCase("imported"))
        {

            this.tax = 0.1 * this.price ;

            if(this.price + this.tax <= 100)
            {
                this.tax += 5 ;
            }
            else if(this.price + this.tax <= 200)
            {
                this.tax += 10 ;
            }
            else
            {
                this.tax += 0.5 * (this.tax + this.price) ;
            }
        }

        //Final Price
        this.finalPrice = this.price + this.tax ;
    }
}
