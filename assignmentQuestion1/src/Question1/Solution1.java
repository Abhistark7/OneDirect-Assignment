
/**
 *
 * @author Abhishek sahu
 */

package Question1;

import java.util.*;

public class Solution1 {

    static List<String> item_names = new ArrayList<String>();
    static List<String> item_types = new ArrayList<String>();
    static List<Integer> item_prices = new ArrayList<Integer>();
    static List<Integer> item_quantity = new ArrayList<Integer>();
    static List<Double> sales_tax = new ArrayList<Double>();
    static List<Double> final_price = new ArrayList<Double>();

    //store index of last item, used to get last item in ArrayList
    static int last_item_index = 0;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //default input choice
        char choice = 'y';

        if(args.length!=0) {
            //input item details
            inputItemDetails(args);
        }

        //Handle multiple item input
        do{

            System.out.println("Do you want to enter details of any other item (y/n)");
            choice = sc.next().charAt(0);
            if(choice == 'y'){

                System.out.println("Enter new item details");

                //Input entire string
                String input = sc.next();
                input += sc.nextLine();

                //Convert input string into a string array of words for operation
                String[] item = input.split("\\s+");

                for (int k = 0; k < item.length; k++) {
                    item[k] = item[k].replaceAll("[^\\w]", "");
                }

                //input item values
                inputItemDetails(item);

            }

        } while(choice == 'y');

        //Display all item details
        for (int j=0; j<item_names.size(); j++) {

            System.out.println("\nItem Name is "+ item_names.get(j));
            System.out.println("Item Price is "+ item_prices.get(j));
            System.out.println("Tax per item is "+ sales_tax.get(j));
            System.out.println("Final Price is "+ final_price.get(j));
            System.out.println("\n---------------------------------------------------------------------------- \n");

        }

    }

    //method to add new item details
    static void inputItemDetails(String[] args){

        //store current attributes
        String currentName = "";
        String currentType = "";
        int currentPrice = 0;
        int currentQuantity = 0;

        //boolean to check whether a specific value is entered or not
        boolean name = false;
        boolean type = false;
        boolean quantity = false;
        boolean price = false;

        for(int i = 0; i<args.length; i++)
        {
            if(args[i].compareTo("-name")==0 || args[i].compareTo("name")==0){
                try {
                    currentName = args[i+1];
                    name = true;
                } catch (ArrayIndexOutOfBoundsException e) { //Handle ArrayIndexOutOfBoundsException
                    System.out.println("Value not entered!!");
                    System.exit(0);
                }
            }
            if(args[i].compareTo("-price")==0 || args[i].compareTo("price")==0){
                try {
                    try {
                        currentPrice = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) { //Handle NumberFormatException
                        System.out.println("Invalid Price!");
                        System.exit(0);
                    }
                    price = true;
                } catch (ArrayIndexOutOfBoundsException e){ //Handle ArrayIndexOutOfBoundsException
                    System.out.println("Value not entered!!");
                    System.exit(0);
                }
            }
            if(args[i].compareTo("-quantity")==0 || args[i].compareTo("quantity")==0){
                try {
                    try {
                        currentQuantity = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) { //Handle NumberFormatException
                        System.out.println("Invalid Quantity!");
                        System.exit(0);
                    }
                    quantity = true;
                } catch (ArrayIndexOutOfBoundsException e){ //Handle ArrayIndexOutOfBoundsException
                    System.out.println("Value not entered!!");
                    System.exit(0);
                }
            }
            if(args[i].compareTo("-type")==0 || args[i].compareTo("type")==0){
                try {
                    if (!correctItemType(args[i + 1])) { //Check if item type is correct
                        System.out.println("Invalid Item Type!");
                        System.exit(0);
                    } else {
                        currentType = args[i + 1];
                        type = true;
                    }
                } catch (ArrayIndexOutOfBoundsException e){ //Handle ArrayIndexOutOfBoundsException
                    System.out.println("Value not entered!!");
                    System.exit(0);
                }
            }

        }

        //check and insert values
        checkValues(currentName, currentPrice, currentQuantity, currentType, name, price, quantity, type);

        //Calculate sales tax and final price
        sales_tax.add(calculate_tax(item_types.get(last_item_index), item_prices.get(last_item_index)));
        final_price.add(sales_tax.get(last_item_index)+item_prices.get(last_item_index));

    }

    //function to calculate tax
    public static double calculate_tax(String type, int price) {

        double tax = 0.0;
        double surcharge = 0.0;
        double final_price = 0.0;

        switch(type){

            case "raw" : tax = price*0.125;
                break;

            case "manufactured" : tax = price*0.125 + 0.02*(price + price*0.125);
                break;

            case "imported" : tax = price*0.1;
                final_price = price + tax;
                if(final_price<=100){
                    surcharge = 5;
                } else if(final_price>100 && final_price<=200) {
                    surcharge = 10;
                } else if(final_price>200){
                    surcharge = final_price*1.1;
                }
                tax = tax + surcharge;

        }

        return tax;

    }

    //method to check whether entered item type is correct or not
    public static boolean correctItemType(String type) {
        boolean correct = false;
        if(type.compareTo("raw")==0 || type.compareTo("manufactured")==0 || type.compareTo("imported")==0){
            correct = true;
        }
        return correct;
    }


    //method to check input values
    public static void checkValues(String curName, int curPrice, int curQuantity, String curType, boolean name, boolean price, boolean quantity, boolean type){

        //check for attributes which are not entered
        if(!name){
            System.out.println("Item name is mandatory!");
            //System.exit(0);
        }
        if(!price){
            System.out.println("Item price not entered, skipping");
            curPrice = 0;
        }
        if(!quantity){
            System.out.println("Item quantity not entered, skipping");
            curQuantity = 0;
        }
        if(!type){
            System.out.println("Item type is mandatory!!");
            System.exit(0);
        }

        //if everything is correct then input values
        insertValues(curName, curPrice, curQuantity, curType);
    }

    //method to input values
    public static void insertValues(String currentName, int currentPrice, int currentQuantity, String currentType){

        if(currentName != null)
        {
        item_names.add(currentName);
        item_prices.add(currentPrice);
        item_quantity.add(currentQuantity);
        item_types.add(currentType);
        }

    }
}
