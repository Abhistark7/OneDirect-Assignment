import Question1.Solution1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {


    @Test // test to check item type
    public void checkItemType(){

        Solution1 inv = new Solution1();
        assertEquals(true, inv.correctItemType("imported"));

    }

    @Test // test to check tax
    public void checkTax(){

        Solution1 inv = new Solution1();
        assertEquals(12.50, inv.calculate_tax("raw", 100));
    }



}