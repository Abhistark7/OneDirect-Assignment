/**
 *
 * @author Abhishek sahu
 */


package Question4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionConfiguration {

    private static Statement st;
    private static ResultSet rs;
    private static List<Item> ItemArray = new ArrayList<>();

    public static List<Item> getConnection() {

        Connection connection = null;

        //Connect to database
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itemdatabase", "root", "");
            st = connection.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }

        //Store item details from database
        try {
            String query = "select * from item";
            rs = st.executeQuery(query);
            while(rs.next()){
                Item item = new Item();
                item.setName(rs.getString("NAME"));
                item.setPrice(rs.getInt("PRICE"));
                item.setQuantity(rs.getInt("QUANTITY"));
                item.setType(rs.getString("TYPE"));
                ItemArray.add(item);
            }

            System.out.println("Records loaded from database\n");

        } catch (Exception e){
            e.printStackTrace();
        }

        return ItemArray;
    }

}
