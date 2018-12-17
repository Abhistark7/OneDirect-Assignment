/**
 *
 * @author Abhishek sahu
 */


package Question4;

import java.util.List;

public class Thread2 implements Runnable{

    private List<Item> ItemList;

    //Constructor
    public Thread2(List<Item> ItemList){
        this.ItemList = ItemList;
    }

    public void run(){

        //Thread2 which calculates tax and displays the data
        synchronized (ItemList) {


            //Calculate Tax & Final Price of each item
            for (int i = 0; i < ItemList.size(); i++) {
                ItemList.get(i).calculateTax();
            }

            System.out.println("Records after calculation of tax and final price");

            //Display details with tax and final price
            for (int j=0; j<ItemList.size(); j++) {

                System.out.println("\nItem Name is "+ ItemList.get(j).getName());
                System.out.println("Item Price is "+ ItemList.get(j).getPrice());
                System.out.println("Tax per item is "+ ItemList.get(j).getTax());
                System.out.println("Final Price is "+ ItemList.get(j).getFinalPrice());
                System.out.println("\n---------------------------------------------------------------------------- \n");

            }
        }
    }
}
