/**
 *
 * @author Abhishek sahu
 */

package Question4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution4 implements Runnable{

    private static List<Item> itemList;

    //Constructor
    public Solution4(List<Item> itemList){
        this.itemList = itemList;
    }

    @Override
    public void run(){

        //Thread1 which requests and stores the data from database into synchronized list
        synchronized (itemList){
        itemList = ConnectionConfiguration.getConnection();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        //Using synchronized list to store the data
        itemList = Collections.synchronizedList(new ArrayList<Item>());
        Thread t1 = new Thread(new Solution4(itemList));
        t1.start();
        t1.join();
        Thread t2 = new Thread(new Thread2(itemList));
        t2.start();

    }

}
